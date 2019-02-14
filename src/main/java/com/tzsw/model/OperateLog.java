package com.tzsw.model;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 16:21 2018/12/6
 */
public class OperateLog {

    private String operateID;
    private String operateType;
    private String serviceCode;
    private String busipacket;
    private String errormsg;

    public String getOperateID() {
        return operateID;
    }

    public void setOperateID(String operateID) {
        this.operateID = operateID;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getBusipacket() {
        return busipacket;
    }

    public void setBusipacket(String busipacket) {
        this.busipacket = busipacket;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
