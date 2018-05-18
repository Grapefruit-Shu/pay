package com.xishanju.payment.remoting.alipay.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.xishanju.payment.remoting.alipay.constans.AlipayConfig;
import com.xishanju.payment.remoting.alipay.service.SendAliOrderApi;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author shuyong
 * @date 2018/5/16 14:53
 */
@Service("sendAliOrderApi")
public class SendAliOrderApiImpl implements SendAliOrderApi {

    private static Logger logger = Logger.getLogger(SendAliOrderApiImpl.class);

    @Override
    public AlipayTradeAppPayResponse queryOrder(AlipayTradeAppPayRequest request) {
        AlipayTradeAppPayResponse response = null;
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.alipay_serverUrl, AlipayConfig.app_id, AlipayConfig.alipay_private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            response = alipayClient.sdkExecute(request);
        } catch (Exception e) {
            logger.error("调用阿里openapi.alipay.com/gateway.do接口失败",e);
        }
        return response;
    }
}
