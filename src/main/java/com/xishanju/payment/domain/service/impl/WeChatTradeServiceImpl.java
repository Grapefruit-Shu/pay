package com.xishanju.payment.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.xishanju.payment.common.OurTradeNo;
import com.xishanju.payment.domain.dto.RequestDto;
import com.xishanju.payment.domain.service.WeChatTradeService;
import com.xishanju.payment.remoting.wechat.constans.WeChatCons;
import com.xishanju.payment.remoting.wechat.service.WeChatPrePayApi;
import com.xishanju.payment.remoting.wechat.util.MyConfig;
import com.xishanju.payment.vo.CredentialVo;
import com.xishanju.payment.vo.OrderVo;
import com.xishanju.payment.vo.WeChatVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 11:00 2018/5/17
 */
@Service("weChatTradeService")
public class WeChatTradeServiceImpl implements WeChatTradeService {

    private static Logger logger = Logger.getLogger(WeChatTradeServiceImpl.class);

    @Resource
    private WeChatPrePayApi weChatPrePayApi;

    @Override
    public OrderVo wechatPrePay(RequestDto requestDto) {
        OrderVo orderVo = new OrderVo();
        Map<String,String> resultMap = new HashMap<>();

        float timestamp = System.currentTimeMillis() / 1000;
        // 参数：开始生成签名
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("appid", WeChatCons.wechat_app_id);
        parameters.put("mch_id", WeChatCons.wechat_mch_id);
        parameters.put("body", requestDto.getBody());
        parameters.put("out_trade_no", OurTradeNo.orderNo());
        parameters.put("total_fee", requestDto.getAmount());
        parameters.put("notify_url", WeChatCons.notify_url);
        parameters.put("trade_type", "APP");
        parameters.put("spbill_create_ip", requestDto.getClient_ip());

        orderVo.setAmount(requestDto.getAmount());
        orderVo.setAmount_settle(requestDto.getClient_ip());
        orderVo.setApp(requestDto.getApp());
        orderVo.setBody(requestDto.getBody());
        orderVo.setPaid(true);
        orderVo.setLivemode(true);
        orderVo.setChannel(requestDto.getChannel());
        orderVo.setClient_ip(requestDto.getClient_ip());
        orderVo.setCurrency(requestDto.getCurrency());
        orderVo.setSubject(requestDto.getSubject());
        orderVo.setOrder_no(parameters.get("out_trade_no").toString());

        CredentialVo credentialVo = new CredentialVo();
        credentialVo.setObject("credential");
        WeChatVo weChatVo = new WeChatVo();
        credentialVo.setWechat(weChatVo);
        orderVo.setCredential(credentialVo);

        try {
            resultMap = weChatPrePayApi.getWeChatPrePay(parameters,new MyConfig());
            if("SUCCESS".equals(resultMap.get("return_code"))){
                SortedMap<Object, Object> againParameters = new TreeMap<Object, Object>();
                againParameters.put("appid", resultMap.get("appid"));
                againParameters.put("partnerid", WeChatCons.wechat_mch_id);
                againParameters.put("prepayid", resultMap.get("prepay_id"));
                againParameters.put("noncestr", resultMap.get("nonce_str"));
                againParameters.put("timestamp", timestamp);
                againParameters.put("package", "Sign=WXPay");
                againParameters.put("sign",resultMap.get("sign"));

                weChatVo.setOrderInfo(JSON.toJSONString(againParameters));
            } else {
                String return_msg = resultMap.get("return_msg");
                logger.error(return_msg);
            }
        } catch (Exception e) {
            logger.error("微信支付异常：",e);
        }

        return orderVo;
    }

}
