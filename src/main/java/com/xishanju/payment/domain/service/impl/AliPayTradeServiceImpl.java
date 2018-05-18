package com.xishanju.payment.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.xishanju.payment.domain.dto.RequestDto;
import com.xishanju.payment.domain.enums.ChannelEnums;
import com.xishanju.payment.domain.service.AliPayTradeService;
import com.xishanju.payment.remoting.alipay.service.SendAliOrderApi;
import com.xishanju.payment.vo.AlipayVo;
import com.xishanju.payment.vo.CredentialVo;
import com.xishanju.payment.vo.OrderVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuyong
 * @date 2018/5/16 16:28
 */
@Service("aliPayTradeService")
public class AliPayTradeServiceImpl implements AliPayTradeService {

    @Resource
    private SendAliOrderApi sendAliOrderApi;

    @Override
    public OrderVo sendAliPayTradeService(RequestDto requestDto) {

        OrderVo orderVo = new OrderVo();

        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setOutTradeNo(System.currentTimeMillis() + "");
        model.setSubject(requestDto.getSubject());
        model.setTotalAmount(requestDto.getAmount());

        request.setBizModel(model);
        request.setNotifyUrl("");
        request.setApiVersion("1.0");
        Map<String, String> biz_content = new HashMap<String, String>();
        biz_content.put("subject", requestDto.getSubject());
        biz_content.put("total_amount", (Float.parseFloat(requestDto.getAmount()) / 100) + "");
        biz_content.put("product_code", "QUICK_MSECURITY_PAY");
        biz_content.put("timeout_express", System.currentTimeMillis() + "");
        request.setBizContent(JSON.toJSONString(biz_content));
        request.setNotifyUrl("http://*****/payment/aliPayOrder.do");
        AlipayTradeAppPayResponse response = sendAliOrderApi.queryOrder(request);

        orderVo.setAmount(requestDto.getAmount());
        orderVo.setApp(requestDto.getApp());
        orderVo.setBody(requestDto.getBody());
        orderVo.setChannel(requestDto.getChannel());
        orderVo.setClient_ip(requestDto.getClient_ip());
        orderVo.setCurrency(requestDto.getCurrency());
        orderVo.setSubject(requestDto.getSubject());
        orderVo.setOrder_no(requestDto.getOrder_no());

        CredentialVo credentialVo = new CredentialVo();
        credentialVo.setObject("credential");
        AlipayVo alipayVo = new AlipayVo();
        alipayVo.setOrderInfo(response.getBody());
        credentialVo.setAlipay(alipayVo);
        orderVo.setCredential(credentialVo);

        return orderVo;
    }
}
