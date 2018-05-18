package com.xishanju.payment.vo;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:37 2018/5/18
 */
public class OrderVo {

    private String id;

    private String object;

    private Long created;

    private boolean livemode;

    private boolean paid;

    private boolean refunded;

    private String app;

    private String channel;

    private String order_no;

    private String client_ip;

    private String amount;

    private String amount_settle;

    private String currency;

    private String subject;

    private String body;

    private Object extra;

    private Long time_paid;

    private Long time_expire;

    private Long time_settle;

    private Long transaction_no;

    private RefundsVo refunds;

    private Long amount_refunded;

    private String failure_code;

    private String failure_msg;

    private Object metadata;

    private CredentialVo credential;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public void setLivemode(boolean livemode) {
        this.livemode = livemode;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
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

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount_settle() {
        return amount_settle;
    }

    public void setAmount_settle(String amount_settle) {
        this.amount_settle = amount_settle;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public Long getTime_paid() {
        return time_paid;
    }

    public void setTime_paid(Long time_paid) {
        this.time_paid = time_paid;
    }

    public Long getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(Long time_expire) {
        this.time_expire = time_expire;
    }

    public Long getTime_settle() {
        return time_settle;
    }

    public void setTime_settle(Long time_settle) {
        this.time_settle = time_settle;
    }

    public Long getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(Long transaction_no) {
        this.transaction_no = transaction_no;
    }

    public RefundsVo getRefunds() {
        return refunds;
    }

    public void setRefunds(RefundsVo refunds) {
        this.refunds = refunds;
    }

    public Long getAmount_refunded() {
        return amount_refunded;
    }

    public void setAmount_refunded(Long amount_refunded) {
        this.amount_refunded = amount_refunded;
    }

    public String getFailure_code() {
        return failure_code;
    }

    public void setFailure_code(String failure_code) {
        this.failure_code = failure_code;
    }

    public String getFailure_msg() {
        return failure_msg;
    }

    public void setFailure_msg(String failure_msg) {
        this.failure_msg = failure_msg;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public CredentialVo getCredential() {
        return credential;
    }

    public void setCredential(CredentialVo credential) {
        this.credential = credential;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
