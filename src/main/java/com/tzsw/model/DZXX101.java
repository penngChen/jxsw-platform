package com.tzsw.model;

/**
 * @Author: chenpeng
 * @Description: 社保费对账信息
 * @Date: Created in 14:28 2018/12/3
 */
public class DZXX101 {

    private String XH;//主键
    private String AAZ400;//社保业务系统编码
    private String SBUUID;//UUID
    private String AAE310;//报表时间起
    private String AAE311;//报表时间止
    private String AAA027;//统筹区编码
    private String AAB034;//社保经办机构编号
    private String AAE140;//险种类型
    private String AAE080;//单位缴费部分入库总金额
    private String AAE082;//个人缴费部分入库总金额
    private String AAE056;//滞纳金入库总金额
    private String BAC121;//单位部分利息
    private String AAE239;//利息入库总金额
    private String AIC152;//其他补助缴费入库总金额
    private String AAA321;//数据传输类型
    private String AAA322;//传输批次号
    private String AAE418;//传输时间戳
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

    public String getAAZ400() {
        return AAZ400;
    }

    public void setAAZ400(String AAZ400) {
        this.AAZ400 = AAZ400;
    }

    public String getSBUUID() {
        return SBUUID;
    }

    public void setSBUUID(String SBUUID) {
        this.SBUUID = SBUUID;
    }

    public String getAAE310() {
        return AAE310;
    }

    public void setAAE310(String AAE310) {
        this.AAE310 = AAE310;
    }

    public String getAAE311() {
        return AAE311;
    }

    public void setAAE311(String AAE311) {
        this.AAE311 = AAE311;
    }

    public String getAAA027() {
        return AAA027;
    }

    public void setAAA027(String AAA027) {
        this.AAA027 = AAA027;
    }

    public String getAAB034() {
        return AAB034;
    }

    public void setAAB034(String AAB034) {
        this.AAB034 = AAB034;
    }

    public String getAAE140() {
        return AAE140;
    }

    public void setAAE140(String AAE140) {
        this.AAE140 = AAE140;
    }

    public String getAAE080() {
        return AAE080;
    }

    public void setAAE080(String AAE080) {
        this.AAE080 = AAE080;
    }

    public String getAAE082() {
        return AAE082;
    }

    public void setAAE082(String AAE082) {
        this.AAE082 = AAE082;
    }

    public String getAAE056() {
        return AAE056;
    }

    public void setAAE056(String AAE056) {
        this.AAE056 = AAE056;
    }

    public String getBAC121() {
        return BAC121;
    }

    public void setBAC121(String BAC121) {
        this.BAC121 = BAC121;
    }

    public String getAAE239() {
        return AAE239;
    }

    public void setAAE239(String AAE239) {
        this.AAE239 = AAE239;
    }

    public String getAIC152() {
        return AIC152;
    }

    public void setAIC152(String AIC152) {
        this.AIC152 = AIC152;
    }

    public String getAAA321() {
        return AAA321;
    }

    public void setAAA321(String AAA321) {
        this.AAA321 = AAA321;
    }

    public String getAAA322() {
        return AAA322;
    }

    public void setAAA322(String AAA322) {
        this.AAA322 = AAA322;
    }

    public String getAAE418() {
        return AAE418;
    }

    public void setAAE418(String AAE418) {
        this.AAE418 = AAE418;
    }

    @Override
    public String toString() {
        return "DZXX101{" +
                "XH='" + XH + '\'' +
                ", AAZ400='" + AAZ400 + '\'' +
                ", SBUUID='" + SBUUID + '\'' +
                ", AAE310='" + AAE310 + '\'' +
                ", AAE311='" + AAE311 + '\'' +
                ", AAA027='" + AAA027 + '\'' +
                ", AAB034='" + AAB034 + '\'' +
                ", AAE140='" + AAE140 + '\'' +
                ", AAE080='" + AAE080 + '\'' +
                ", AAE082='" + AAE082 + '\'' +
                ", AAE056='" + AAE056 + '\'' +
                ", BAC121='" + BAC121 + '\'' +
                ", AAE239='" + AAE239 + '\'' +
                ", AIC152='" + AIC152 + '\'' +
                ", AAA321='" + AAA321 + '\'' +
                ", AAA322='" + AAA322 + '\'' +
                ", AAE418='" + AAE418 + '\'' +
                '}';
    }
}
