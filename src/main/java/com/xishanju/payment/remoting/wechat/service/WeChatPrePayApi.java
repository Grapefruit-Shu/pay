package com.xishanju.payment.remoting.wechat.service;

import com.xishanju.payment.remoting.wechat.util.MyConfig;

import java.util.Map;
import java.util.SortedMap;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:21 2018/5/17
 */
public interface WeChatPrePayApi {

    Map<String,String> getWeChatPrePay(SortedMap<String, String> parameters, MyConfig config);
}
