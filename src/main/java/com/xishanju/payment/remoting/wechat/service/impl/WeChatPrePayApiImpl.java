package com.xishanju.payment.remoting.wechat.service.impl;

import com.xishanju.payment.remoting.wechat.constans.WeChatCons;
import com.xishanju.payment.remoting.wechat.service.WeChatPrePayApi;
import com.xishanju.payment.utils.HttpXmlUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:22 2018/5/17
 */
@Service("weChatPrePayApi")
public class WeChatPrePayApiImpl implements WeChatPrePayApi {

    private static Logger logger = Logger.getLogger(WeChatPrePayApiImpl.class);

    @Override
    public Map<String,String> getWeChatPrePay(String requestXML) {
        Map<String,String> resultMap = new HashMap<>();
        try {
            String result = HttpXmlUtils.httpsRequest(WeChatCons.wechat_orderUrl, WeChatCons.request_method,requestXML);
            resultMap = HttpXmlUtils.doXMLParse(result);
        } catch (Exception e) {
            logger.error("解析XML异常",e);
        }
        return resultMap;
    }
}
