package com.tzsw.support;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 17:12 2018/10/29
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS("200", "成功"),

    /**
     * 失败，请重试
     */
    SUCCESS_FAIL("202", "系统繁忙,请稍候重试"),

    /**
     * 发生异常
     */
    EXCEPTION("401", "系统出现异常"),

    /**
     * 系统错误
     */
    SYS_ERROR("402", "系统错误"),

    /**
     * 参数错误
     */
    PARAMS_ERROR("403", "参数错误"),

    /**
     * 未知的错误
     */
    UNKNOWN_ERROR("499", "未知错误");

    private ResultCode(String val, String msg) {
        this.val = val;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
}
