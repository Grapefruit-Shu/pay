package com.xishanju.payment.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.xishanju.payment.domain.dto.RequestDto;
import com.xishanju.payment.domain.enums.ChannelEnums;
import com.xishanju.payment.domain.service.AliPayTradeService;
import com.xishanju.payment.remoting.alipay.constans.AlipayConfig;
import com.xishanju.payment.remoting.alipay.service.SendAliOrderApi;
import com.xishanju.payment.vo.AlipayVo;
import com.xishanju.payment.vo.CredentialVo;
import com.xishanju.payment.vo.OrderVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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

        BigDecimal yuanToFen = new BigDecimal(100);

        OrderVo orderVo = new OrderVo();

        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setOutTradeNo(requestDto.getOrder_no());
        model.setSubject(requestDto.getSubject());
        model.setTotalAmount(requestDto.getAmount());
        model.setTimeoutExpress(requestDto.getTimeOutExpress());
        model.setProductCode(AlipayConfig.product_code);
        model.setBody(requestDto.getBody());

        request.setBizModel(model);
        request.setApiVersion("1.0");

        request.setNotifyUrl(AlipayConfig.notify_url);
        AlipayTradeAppPayResponse response = sendAliOrderApi.queryOrder(request);

        orderVo.setAmount(requestDto.getAmount());
        orderVo.setAmount_settle(new BigDecimal(requestDto.getAmount()).multiply(yuanToFen).toString());
        orderVo.setApp(requestDto.getApp());
        orderVo.setBody(requestDto.getBody());
        orderVo.setPaid(true);
        orderVo.setLivemode(true);
        orderVo.setChannel(requestDto.getChannel());
        orderVo.setClient_ip(requestDto.getClient_ip());
        orderVo.setCurrency(requestDto.getCurrency());
        orderVo.setSubject(requestDto.getSubject());
        orderVo.setOrder_no(requestDto.getOrder_no());

        CredentialVo credentialVo = new CredentialVo();
        AlipayVo alipayVo = new AlipayVo();
        alipayVo.setOrderInfo(response.getBody());
        credentialVo.setAlipay(alipayVo);
        orderVo.setCredential(credentialVo);

        return orderVo;
    }
}
