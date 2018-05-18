package com.xishanju.payment.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.xishanju.payment.domain.dto.RequestDto;
import com.xishanju.payment.domain.service.WeChatTradeService;
import com.xishanju.payment.remoting.wechat.constans.WeChatCons;
import com.xishanju.payment.utils.HttpXmlUtils;
import com.xishanju.payment.utils.StringUtil;
import com.xishanju.payment.utils.WxSignUtils;
import com.xishanju.payment.vo.OrderVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 11:00 2018/5/17
 */
@Service("weChatTradeService")
public class WeChatTradeServiceImpl implements WeChatTradeService {

    @Override
    public OrderVo wechatPrePay(RequestDto requestDto) {
        Map<String,String> result=new HashMap<String, String>();
        //随机字符
        String nonce_str = StringUtil.getRandomNum(8);

        String body = requestDto.getBody();

        String total_fee = requestDto.getAmount();
        String spbill_create_ip = requestDto.getClient_ip();// "127.0.0.1";
        String notify_url = "";
        System.out.println("notify_url是：" + notify_url);
        //支付类型
        String trade_type = "APP";

        float timestamp = System.currentTimeMillis() / 1000;
        // 参数：开始生成签名
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", WeChatCons.wechat_app_id);
        parameters.put("mch_id", WeChatCons.wechat_mch_id);
        parameters.put("nonce_str", nonce_str);
        parameters.put("body", body);
        parameters.put("out_trade_no", "");
        parameters.put("total_fee", total_fee);
        parameters.put("notify_url", notify_url);
        parameters.put("trade_type", trade_type);
        parameters.put("spbill_create_ip", spbill_create_ip);
        String sign = WxSignUtils.createSign("UTF-8", parameters,WeChatCons.API_KEY);
        System.out.println("签名是：" + sign);
        parameters.put("sign", sign);
        // 构造xml参数
        String xmlInfo = HttpXmlUtils.xmlInfo(parameters);
        String payNo = HttpXmlUtils.httpsRequest("wxPayUrl", xmlInfo);
        System.out.println("请求结果" + payNo);
        Map doXMLParse = null;
        String signStr = "";
        try {
            doXMLParse = HttpXmlUtils.doXMLParse(payNo);
            if("SUCCESS".equals(doXMLParse.get("return_code"))){
                SortedMap<Object, Object> againParameters = new TreeMap<Object, Object>();
                againParameters.put("appid", doXMLParse.get("appid"));
                againParameters.put("partnerid", "wx_native_mch_id");
                againParameters.put("prepayid", doXMLParse.get("prepay_id"));
                againParameters.put("noncestr", StringUtil.getRandomNum(8));
                againParameters.put("timestamp", System.currentTimeMillis() / 1000);
                againParameters.put("package", "Sign=WXPay");
                String sign1 = WxSignUtils.createSign("UTF-8", againParameters,"wx_native_key");
                againParameters.put("sign", sign1);
                signStr = JSON.toJSONString(againParameters);
                System.out.println("再次签名结果" + signStr);
                result.put("code", "SUCCESS");
                result.put("msg", "签名成功");
                result.put("data", signStr);
                result.put("out_trade_no", "");
            }else{
                result.put("code", "ERROR");
                result.put("msg", "签名失败");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        result.put("service", "微信支付");
        return null;
    }
}
