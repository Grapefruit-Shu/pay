package com.xishanju.payment.dto;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:07 2018/5/18
 */
public class OrderDetailDto {

    private long order_no;

    private String amount;

    private String app;

    private String subject;

    private String body;

    public long getOrder_no() {
        return order_no;
    }

    public void setOrder_no(long order_no) {
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
