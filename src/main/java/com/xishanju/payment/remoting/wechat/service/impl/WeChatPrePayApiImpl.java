package com.xishanju.payment.remoting.wechat.service.impl;

import com.xishanju.payment.remoting.wechat.constans.WeChatCons;
import com.xishanju.payment.remoting.wechat.service.WeChatPrePayApi;
import com.xishanju.payment.remoting.wechat.util.MyConfig;
import com.xishanju.payment.remoting.wechat.util.WXPay;
import com.xishanju.payment.utils.HttpXmlUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:22 2018/5/17
 */
@Service("weChatPrePayApi")
public class WeChatPrePayApiImpl implements WeChatPrePayApi {

    private static Logger logger = Logger.getLogger(WeChatPrePayApiImpl.class);

    @Override
    public Map<String,String> getWeChatPrePay(SortedMap<String, String> parameters,MyConfig config) {
        WXPay wxPay = new WXPay(config);
        Map<String,String> resultMap = new HashMap<>();
        try {
            resultMap = wxPay.unifiedOrder(parameters);
        } catch (Exception e) {
            logger.error("请求订单异常",e);
        }
        return resultMap;
    }
}
