package com.xishanju.payment.remoting.alipay.constans;

import com.xishanju.payment.core.LoadProperties;

/**
 * @author shuyong
 * @date 2018/5/15 17:16
 */
public class AlipayConfig {

    //合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
    public static String partner = LoadProperties.getProperties("alipay_partner");

    //商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
    public static String alipay_private_key = LoadProperties.getProperties("alipay_private_key");

    //支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
    public static String alipay_public_key = LoadProperties.getProperties("alipay_public_key");

    // 签名方式
    public static String sign_type = "RSA2";

    // 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
    public static String log_path ="C://";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String charset = "utf-8";

    //阿里支付url
    public static String alipay_serverUrl = LoadProperties.getProperties("alipay_serverUrl");

    //参数格式
    public static String format = "json";

    //APPID
    public static String app_id = LoadProperties.getProperties("alipay_app_id");

    public static String product_code = LoadProperties.getProperties("alipay_product_code");

    // 接收通知的接口名
    public static String notify_url = LoadProperties.getProperties("alipay_notify_url");

    public void reload() {

    }
}
