package com.xishanju.payment.remoting.wechat.service;

import java.util.Map;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:21 2018/5/17
 */
public interface WeChatPrePayApi {

    Map<String,String> getWeChatPrePay(String requestXML);
}
