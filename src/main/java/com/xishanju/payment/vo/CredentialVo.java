package com.xishanju.payment.vo;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:44 2018/5/18
 */
public class CredentialVo {

    private String object;

    private AlipayVo alipay;

    public String getObject() {
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
}
