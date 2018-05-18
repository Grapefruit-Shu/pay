package com.xishanju.payment.common;

public interface RetCode {

    /** 成功 **/
    String SUCCESS         = "200";
    /** 失败 **/
    String ERROR           = "1001";

    /** 流水号重复 **/
    String REQNO_DUPLICATE = "900000";

    /** 签名错误 **/
    String SIGN_ERROR      = "900001";

    /** 参数错误 **/
    String PARAM_ERROR     = "900002";

    /** HTTP调用发生错误 **/
    String HTTP_CALL_ERROR = "900003";

    /** 找不到配置 **/
    String CFG_NOT_FOUND   = "900004";
}
