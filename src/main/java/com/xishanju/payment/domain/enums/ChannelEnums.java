package com.xishanju.payment.domain.enums;

import org.springframework.util.StringUtils;

public enum ChannelEnums {

    NULL((String) "null", "------"),

    ALI((String) "alipay", "阿里支付"),

    WEIXIN((String) "wechatpay", "微信支付"),

    ;

    ChannelEnums(String type, String text) {
        this.type = type;
        this.text = text;
    }

    private String type;
    private String text;

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static ChannelEnums getEnum(String text) {
        ChannelEnums e = ChannelEnums.NULL;
        if (!StringUtils.isEmpty(text)) {
            for (ChannelEnums o : ChannelEnums.values()) {
                if (o.getText().equals(text)) {
                    e = o;
                }
            }
        }
        return e;
    }
}
