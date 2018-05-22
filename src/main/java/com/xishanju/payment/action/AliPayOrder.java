package com.xishanju.payment.action;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.xishanju.payment.common.Result;
import com.xishanju.payment.common.RetCode;
import com.xishanju.payment.remoting.alipay.constans.AlipayConfig;
import com.xishanju.payment.utils.HttpXmlUtils;
import com.xishanju.payment.utils.WxSignUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 11:37 2018/5/18
 */
@RequestMapping("/payment")
public class AliPayOrder {

    private static Logger logger = Logger.getLogger(AliPayOrder.class);

    @RequestMapping("/aliPayOrder.do")
    public Result aliPayOrder(@RequestParam("trade_status") String trade_status,
                              HttpServletRequest request) {

        Map<String,String> params = new HashMap<String,String>();
        System.out.println("异步通知参数：");
        Map<String,String[]> requestParams  = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }

        String msg = "";

        Result result = new Result(trade_status);
        try {
            boolean flag = AlipaySignature.rsaCheckV1(params,
                    AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
            if (flag) {
                if ("WAIT_BUYER_PAY".equals(trade_status)) {
                    msg = "交易创建，等待买家付款";
                    trade_status = "USERPAYING";
                } else if ("TRADE_CLOSED".equals(trade_status)) {
                    msg = "未付款交易超时关闭，或支付完成后全额退款";
                    trade_status = "PAYCLOSED";
                } else if ("TRADE_SUCCESS".equals(trade_status)) {

                    msg = "交易支付成功";
                    trade_status = "SUCCESS";
                } else if ("TRADE_FINISHED".equals(trade_status)) {
                    msg = "交易结束，不可退款";
                    trade_status = "PAYFINISHED";
                }

            } else {
                msg = "系统验签出错";
                trade_status = "ERROR";
            }
        } catch (AlipayApiException e) {
            result.setCode(RetCode.ERROR);
            msg = "系统验签异常";
            trade_status = "ERROR";
        }
        result.setValue(trade_status);
        result.setMessage(msg);


        if ("USERPAYING".equals(trade_status)) {  // 支付中
            result.setMessage("支付中");

        } else if ("SUCCESS".equals(trade_status)) {   // 支付成功
            result.setMessage("支付成功");

        } else if ("PAYFINISHED".equals(trade_status)) {  // 交易完成
            result.setMessage("交易完成");

        } else if ("TRADE_CLOSED".equals(trade_status)) {  // 交易结束
            result.setMessage("交易结束");

        }
        return result;
    }

    @RequestMapping("/wechatNotify.do")
    public void wechatNotify(HttpServletRequest request,
                             HttpServletResponse response) {
        try {
            // 读取参数
            InputStream inputStream;
            StringBuffer sb = new StringBuffer();
            inputStream = request.getInputStream();
            String s;
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    inputStream, "UTF-8"));
            while ((s = in.readLine()) != null) {
                sb.append(s);
            }
            in.close();
            inputStream.close();

            // 解析xml成map
            Map m = new HashMap();
            m = HttpXmlUtils.doXMLParse(sb.toString());

            // 过滤空 设置 TreeMap
            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            Iterator it = m.keySet().iterator();
            while (it.hasNext()) {
                String parameter = (String) it.next();
                String parameterValue = (String) m.get(parameter);

                String v = "";
                if (null != parameterValue) {
                    v = parameterValue.trim();
                }
                packageParams.put(parameter, v);
            }

            String code = "";
            String msg = "";

            // 判断签名是否正确
            if (WxSignUtils.isWxPaySign("UTF-8", packageParams)) {
                // ------------------------------
                // 处理业务开始

                // ------------------------------
                String resXml = "";
                if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
                    code = "SUCCESS";
                    msg = "支付成功";

                    // 支付成功
                    String mch_id = (String) packageParams.get("mch_id");
                    String out_trade_no = (String) packageParams
                            .get("out_trade_no");
                    String trade_no = packageParams.get("transaction_id") + "";
                    String total_fee = (String) packageParams.get("total_fee");

                    // //////// 执行自己的业务逻辑////////////////

                    logger.info("支付成功。。。。");
                    // 通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
                    resXml = "<xml>"
                            + "<return_code><![CDATA[SUCCESS]]></return_code>"
                            + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";

                } else {
                    logger.info("支付失败,错误信息：" + packageParams.get("err_code"));

                    resXml = "<xml>"
                            + "<return_code><![CDATA[FAIL]]></return_code>"
                            + "<return_msg><![CDATA[报文为空]]></return_msg>"
                            + "</xml> ";
                    msg = "支付失败";
                    code = "FAIL";

                }
                // ------------------------------
                // 处理业务完毕
                // ------------------------------
                BufferedOutputStream out = new BufferedOutputStream(
                        response.getOutputStream());
                out.write(resXml.getBytes());
                out.flush();
                out.close();
            } else {
                logger.error("验签错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
