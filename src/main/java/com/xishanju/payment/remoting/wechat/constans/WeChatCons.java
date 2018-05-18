package com.xishanju.payment.remoting.wechat.constans;

import com.xishanju.payment.core.LoadProperties;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:41 2018/5/17
 */
public class WeChatCons {

    //下单url  沙盒模式url
    public static String wechat_orderUrl = "https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder";
    public static String wechat_orderUrl_dev = LoadProperties.getProperties("wechat_orderUrl");

    //正式环境url
//    public static String orderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    //统一退款Url
    public static String refundUrl = "";

    public static String request_method = "POST";

    //微信参数配置
    public static String API_KEY="";
    public static String wechat_app_id="wx9b74565b12c7c70f";
    public static String wechat_app_id_dev = LoadProperties.getProperties("wechat_app_id");
    public static String wechat_mch_id="1305638280";
    public static String wechat_mch_id_dev = LoadProperties.getProperties("wechat_mch_id");

    public void reload() {

    }
}
