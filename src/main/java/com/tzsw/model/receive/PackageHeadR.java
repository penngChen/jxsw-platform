package com.tzsw.model.receive;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 9:49 2018/12/5
 */
public class PackageHeadR {

    private String SJBBH;
    private String SJBLX;
    private String JGBS;//社保业务系统编码
    private String DWDM;
    private String DWMC;
    private String RECODE_ZT;//通知报文接收状态代码 0成功；1失败；
    private String REMSG_ZT;//成功 ;失败
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

    public String getJGBS() {
        return JGBS;
    }

    public void setJGBS(String JGBS) {
        this.JGBS = JGBS;
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

    public String getRECODE_ZT() {
        return RECODE_ZT;
    }

    public void setRECODE_ZT(String RECODE_ZT) {
        this.RECODE_ZT = RECODE_ZT;
    }

    public String getREMSG_ZT() {
        return REMSG_ZT;
    }

    public void setREMSG_ZT(String REMSG_ZT) {
        this.REMSG_ZT = REMSG_ZT;
    }

    public String getSCRQ() {
        return SCRQ;
    }

    public void setSCRQ(String SCRQ) {
        this.SCRQ = SCRQ;
    }
}
