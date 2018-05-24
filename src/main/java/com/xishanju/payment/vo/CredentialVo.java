package com.xishanju.payment.vo;

import com.xishanju.payment.utils.StringUtil;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:44 2018/5/18
 */
public class CredentialVo {

    private String object;

    private AlipayVo alipay;

    private WeChatVo wechat;

    public String getObject() {
        if (StringUtil.isEmpty(object)) {
            return "credential";
        }
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public AlipayVo getAlipay() {
        return alipay;
    }

    public void setAlipay(AlipayVo alipay) {
        this.alipay = alipay;
    }

    public WeChatVo getWechat() {
        return wechat;
    }

    public void setWechat(WeChatVo wechat) {
        this.wechat = wechat;
    }
}
