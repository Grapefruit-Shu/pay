package com.xishanju.payment.remoting.wechat.constans;

import com.xishanju.payment.core.LoadProperties;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:41 2018/5/17
 */
public class WeChatCons {

    //回调接口Url
    public static String notify_url = "https://blog.csdn.net/android_xc/article/details/54137850";

    public static String request_method = "POST";

    //微信参数配置
    public static String API_KEY = LoadProperties.getProperties("wechat_key");
    public static String wechat_app_id = LoadProperties.getProperties("wechat_app_id");
    public static String wechat_mch_id = LoadProperties.getProperties("wechat_mch_id");

    public void reload() {

    }
}
