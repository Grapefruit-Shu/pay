package com.xishanju.payment.remoting.wechat.constans;

import com.xishanju.payment.core.LoadProperties;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:41 2018/5/17
 */
public class WeChatCons {

    //下单url  沙盒模式url
    public static String wechat_orderUrl = LoadProperties.getProperties("wechat_orderUrl");

    //正式环境url
//    public static String orderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    //回调接口Url
    public static String notify_url = "https://blog.csdn.net/android_xc/article/details/54137850";

    public static String request_method = "POST";

    //微信参数配置
    public static String API_KEY="2ab9071b06b9f739b950ddb41db2690d";
    public static String wechat_app_id = LoadProperties.getProperties("wechat_app_id");
    public static String wechat_mch_id = LoadProperties.getProperties("wechat_mch_id");

    public void reload() {

    }
}
