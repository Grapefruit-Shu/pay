package com.xishanju.payment.remoting.alipay.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.xishanju.payment.PaymentApplication;
import com.xishanju.payment.remoting.alipay.constans.AlipayConfig;
import com.xishanju.payment.remoting.alipay.service.SendAliOrderApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PaymentApplication.class)
@WebAppConfiguration
public class SendAliOrderApiImplTest {

    @Resource
    private SendAliOrderApi sendAliOrderApi;

    @Test
    public void queryOrder() throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.alipay_serverUrl,AlipayConfig.app_id,AlipayConfig.alipay_private_key,
                AlipayConfig.format,AlipayConfig.charset,AlipayConfig.alipay_public_key,AlipayConfig.sign_type);
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付java");
        model.setOutTradeNo("65465465");
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.02");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        try {
            AlipayTradeAppPayResponse response = sendAliOrderApi.queryOrder(request);
            System.out.println(response);
        } catch (Exception e) {

        }
    }

}