package com.xishanju.payment.remoting.alipay.service;

import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public interface SendAliOrderApi {

    AlipayTradeAppPayResponse queryOrder(AlipayTradeAppPayRequest request);
}
