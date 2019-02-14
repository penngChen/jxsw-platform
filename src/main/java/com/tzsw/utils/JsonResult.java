package com.tzsw.utils;

import com.tzsw.support.ResultCode;

import java.io.Serializable;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 17:12 2018/10/29
 */
public class JsonResult implements Serializable {
    private String code;
    private String msg;
    private Object data;


    public JsonResult() {
        this.setCode(ResultCode.SUCCESS);
        this.setMsg(ResultCode.SUCCESS.msg());
    }

    public JsonResult(ResultCode code) {
        this.setCode(code);
        this.setMsg(code.msg());
    }

    public JsonResult(ResultCode code, String message) {
        this.setCode(code);
        this.setMsg(message);
    }

    public JsonResult(ResultCode code, Object data) {
        this.setCode(code);
        this.setMsg(code.msg());
        this.setData(data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.val();
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
