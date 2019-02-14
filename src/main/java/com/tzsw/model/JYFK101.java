package com.tzsw.model;

/**
 * @Author: chenpeng
 * @Description: 校验反馈信息
 * @Date: Created in 16:07 2018/11/30
 */
public class JYFK101 {

    private String SJBLX;
    private String SJBBH;
    private String RECORD_INDEX;
    private String SJX;
    private String SJXNR;
    private String RKHJYSBYY;
    private String DATABH;

    public String getDATABH() {
        return DATABH;
    }

    public void setDATABH(String DATABH) {
        this.DATABH = DATABH;
    }

    public String getSJBLX() {
        return SJBLX;
    }

    public void setSJBLX(String SJBLX) {
        this.SJBLX = SJBLX;
    }

    public String getSJBBH() {
        return SJBBH;
    }

    public void setSJBBH(String SJBBH) {
        this.SJBBH = SJBBH;
    }

    public String getRECORD_INDEX() {
        return RECORD_INDEX;
    }

    public void setRECORD_INDEX(String RECORD_INDEX) {
        this.RECORD_INDEX = RECORD_INDEX;
    }

    public String getSJX() {
        return SJX;
    }

    public void setSJX(String SJX) {
        this.SJX = SJX;
    }

    public String getSJXNR() {
        return SJXNR;
    }

    public void setSJXNR(String SJXNR) {
        this.SJXNR = SJXNR;
    }

    public String getRKHJYSBYY() {
        return RKHJYSBYY;
    }

    public void setRKHJYSBYY(String RKHJYSBYY) {
        this.RKHJYSBYY = RKHJYSBYY;
    }

    @Override
    public String toString() {
        return "JYFK101{" +
                "SJBLX='" + SJBLX + '\'' +
                ", SJBBH='" + SJBBH + '\'' +
                ", RECORD_INDEX='" + RECORD_INDEX + '\'' +
                ", SJX='" + SJX + '\'' +
                ", SJXNR='" + SJXNR + '\'' +
                ", RKHJYSBYY='" + RKHJYSBYY + '\'' +
                '}';
    }
}
