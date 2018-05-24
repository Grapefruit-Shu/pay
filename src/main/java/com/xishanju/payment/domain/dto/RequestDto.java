package com.xishanju.payment.domain.dto;

/**
 * @author shuyong
 * @date 2018/5/16 16:30
 */
public class RequestDto {

    /**
     * 订单编号
     */
    private String order_no;

    /**
     * 订单金额
     */
    private String amount;

    private String app;

    private String channel;

    private String currency;

    private String client_ip;

    private String subject;

    private String body;

    private String timeOutExpress;

    private String trade_type;

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTimeOutExpress() {
        return timeOutExpress;
    }

    public void setTimeOutExpress(String timeOutExpress) {
        this.timeOutExpress = timeOutExpress;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
