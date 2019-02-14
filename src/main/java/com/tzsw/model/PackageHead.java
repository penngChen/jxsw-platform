package com.tzsw.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:50 2018/11/27
 */
@XStreamAlias("PackageHead")
public class PackageHead {

    private String SJBBH;
    private String SJBLX;
    private String SFCF;
    private String DWDM;
    private String DWMC;
    private String JGBS;//业务系统编码(机构标识)
    private String JLS;
    private String SCRQ;

    public String getSJBBH() {
        return SJBBH;
    }

    public void setSJBBH(String SJBBH) {
        this.SJBBH = SJBBH;
    }

    public String getSJBLX() {
        return SJBLX;
    }

    public void setSJBLX(String SJBLX) {
        this.SJBLX = SJBLX;
    }

    public String getSFCF() {
        return SFCF;
    }

    public void setSFCF(String SFCF) {
        this.SFCF = SFCF;
    }

    public String getDWDM() {
        return DWDM;
    }

    public void setDWDM(String DWDM) {
        this.DWDM = DWDM;
    }

    public String getDWMC() {
        return DWMC;
    }

    public void setDWMC(String DWMC) {
        this.DWMC = DWMC;
    }

    public String getJGBS() {
        return JGBS;
    }

    public void setJGBS(String JGBS) {
        this.JGBS = JGBS;
    }

    public String getJLS() {
        return JLS;
    }

    public void setJLS(String JLS) {
        this.JLS = JLS;
    }

    public String getSCRQ() {
        return SCRQ;
    }

    public void setSCRQ(String SCRQ) {
        this.SCRQ = SCRQ;
    }

    @Override
    public String toString() {
        return "PackageHead{" +
                "SJBBH='" + SJBBH + '\'' +
                ", SJBLX='" + SJBLX + '\'' +
                ", SFCF='" + SFCF + '\'' +
                ", DWDM='" + DWDM + '\'' +
                ", DWMC='" + DWMC + '\'' +
                ", JGBS='" + JGBS + '\'' +
                ", JLS='" + JLS + '\'' +
                ", SCRQ='" + SCRQ + '\'' +
                '}';
    }
}
