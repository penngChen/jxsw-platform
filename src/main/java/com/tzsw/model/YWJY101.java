package com.tzsw.model;

/**
 * @Author: chenpeng
 * @Description: 校验反馈信息
 * @Date: Created in 16:11 2018/11/30
 */
public class YWJY101 {

    private String XH;
    private String YWXH;
    private String CSSJC;
    private String CLZT;
    private String SBYY_DM;
    private String SBYY;
    private String SJTB_SJ;
    private String LRR_DM;
    private String LRRQ;
    private String XGR_DM;
    private String XGRQ;
    private String DATABH;

    public String getDATABH() {
        return DATABH;
    }

    public void setDATABH(String DATABH) {
        this.DATABH = DATABH;
    }

    public String getXH() {
        return XH;
    }

    public void setXH(String XH) {
        this.XH = XH;
    }

    public String getYWXH() {
        return YWXH;
    }

    public void setYWXH(String YWXH) {
        this.YWXH = YWXH;
    }

    public String getCSSJC() {
        return CSSJC;
    }

    public void setCSSJC(String CSSJC) {
        this.CSSJC = CSSJC;
    }

    public String getCLZT() {
        return CLZT;
    }

    public void setCLZT(String CLZT) {
        this.CLZT = CLZT;
    }

    public String getSBYY_DM() {
        return SBYY_DM;
    }

    public void setSBYY_DM(String SBYY_DM) {
        this.SBYY_DM = SBYY_DM;
    }

    public String getSBYY() {
        return SBYY;
    }

    public void setSBYY(String SBYY) {
        this.SBYY = SBYY;
    }

    public String getSJTB_SJ() {
        return SJTB_SJ;
    }

    public void setSJTB_SJ(String SJTB_SJ) {
        this.SJTB_SJ = SJTB_SJ;
    }

    public String getLRR_DM() {
        return LRR_DM;
    }

    public void setLRR_DM(String LRR_DM) {
        this.LRR_DM = LRR_DM;
    }

    public String getLRRQ() {
        return LRRQ;
    }

    public void setLRRQ(String LRRQ) {
        this.LRRQ = LRRQ;
    }

    public String getXGR_DM() {
        return XGR_DM;
    }

    public void setXGR_DM(String XGR_DM) {
        this.XGR_DM = XGR_DM;
    }

    public String getXGRQ() {
        return XGRQ;
    }

    public void setXGRQ(String XGRQ) {
        this.XGRQ = XGRQ;
    }

    @Override
    public String toString() {
        return "YWJY101{" +
                "XH='" + XH + '\'' +
                ", YWXH='" + YWXH + '\'' +
                ", CSSJC='" + CSSJC + '\'' +
                ", CLZT='" + CLZT + '\'' +
                ", SBYY_DM='" + SBYY_DM + '\'' +
                ", SBYY='" + SBYY + '\'' +
                ", SJTB_SJ='" + SJTB_SJ + '\'' +
                ", LRR_DM='" + LRR_DM + '\'' +
                ", LRRQ='" + LRRQ + '\'' +
                ", XGR_DM='" + XGR_DM + '\'' +
                ", XGRQ='" + XGRQ + '\'' +
                '}';
    }
}
