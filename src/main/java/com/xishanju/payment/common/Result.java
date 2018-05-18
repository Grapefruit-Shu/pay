package com.xishanju.payment.common;

public class Result {

    // 返回码
    private String code;
    // 错误消息
    private String message;
    // 返回结果
    private Object value;
    // 当returnCode=300 重定向时，使用此URL重新请求
    private String redirect;


    /**
     * 默认返回值为200(成功)
     * 
     * @param value
     */
    public Result(Object value) {
        super();
        this.code = RetCode.SUCCESS;
        this.value = value;
    }


    public Result(String code, Object value) {
        super();
        this.code = code;
        this.value = value;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public Object getValue() {
        return value;
    }


    public void setValue(Object value) {
        this.value = value;
    }


    public String getRedirect() {
        return redirect;
    }


    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

}
