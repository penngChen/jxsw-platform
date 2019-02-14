package com.tzsw.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: chenpeng
 * @Description:单位参保信息 基础信息JCXX
 * @Date: Created in 15:06 2018/11/27
 */
@XStreamAlias("CBXX")
public class CBXX101 {

    private String XH;//主键
    private String AAZ400;//社保业务系统编码
    private String SBUUID;//UUID
    private String AAB001;//单位编号
    private String AAB998;//统一社会信用代码
    private String AAB003;//组织机构代码
    private String AAB004;//单位名称
    private String AAB301;//登记注册地所在行政区划代码
    private String AAE004;//联系人姓名
    private String AAE005;//联系电话
    private String AAE006;//联系地址
    private String AAE007;//邮政编码
    private String AAB065;//特殊单位类别代码
    private String AAE036;//经办时间
    private String AAA321;//数据传输类型
    private String AAA322;//传输批次号
    private String AAE418;//传输时间戳
    private String AAE419;//处理状态
    private String AAE420;//失败原因代码
    private String AAE421;//失败原因
    private String AAE422;//数据同步时间
    private String AAE423;//录入人代码
    private String AAE424;//录入日期
    private String AAE425;//修改人代码
    private String AAE426;//修改日期
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

    public String getAAB001() {
        return AAB001;
    }

    public void setAAB001(String AAB001) {
        this.AAB001 = AAB001;
    }

    public String getAAB998() {
        return AAB998;
    }

    public void setAAB998(String AAB998) {
        this.AAB998 = AAB998;
    }

    public String getAAB003() {
        return AAB003;
    }

    public void setAAB003(String AAB003) {
        this.AAB003 = AAB003;
    }

    public String getAAB004() {
        return AAB004;
    }

    public void setAAB004(String AAB004) {
        this.AAB004 = AAB004;
    }

    public String getAAB301() {
        return AAB301;
    }

    public void setAAB301(String AAB301) {
        this.AAB301 = AAB301;
    }

    public String getAAE004() {
        return AAE004;
    }

    public void setAAE004(String AAE004) {
        this.AAE004 = AAE004;
    }

    public String getAAE005() {
        return AAE005;
    }

    public void setAAE005(String AAE005) {
        this.AAE005 = AAE005;
    }

    public String getAAE006() {
        return AAE006;
    }

    public void setAAE006(String AAE006) {
        this.AAE006 = AAE006;
    }

    public String getAAE007() {
        return AAE007;
    }

    public void setAAE007(String AAE007) {
        this.AAE007 = AAE007;
    }

    public String getAAB065() {
        return AAB065;
    }

    public void setAAB065(String AAB065) {
        this.AAB065 = AAB065;
    }

    public String getAAE036() {
        return AAE036;
    }

    public void setAAE036(String AAE036) {
        this.AAE036 = AAE036;
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

    public String getAAE419() {
        return AAE419;
    }

    public void setAAE419(String AAE419) {
        this.AAE419 = AAE419;
    }

    public String getAAE420() {
        return AAE420;
    }

    public void setAAE420(String AAE420) {
        this.AAE420 = AAE420;
    }

    public String getAAE421() {
        return AAE421;
    }

    public void setAAE421(String AAE421) {
        this.AAE421 = AAE421;
    }

    public String getAAE422() {
        return AAE422;
    }

    public void setAAE422(String AAE422) {
        this.AAE422 = AAE422;
    }

    public String getAAE423() {
        return AAE423;
    }

    public void setAAE423(String AAE423) {
        this.AAE423 = AAE423;
    }

    public String getAAE424() {
        return AAE424;
    }

    public void setAAE424(String AAE424) {
        this.AAE424 = AAE424;
    }

    public String getAAE425() {
        return AAE425;
    }

    public void setAAE425(String AAE425) {
        this.AAE425 = AAE425;
    }

    public String getAAE426() {
        return AAE426;
    }

    public void setAAE426(String AAE426) {
        this.AAE426 = AAE426;
    }

    @Override
    public String toString() {
        return "CBXX101{" +
                "XH='" + XH + '\'' +
                ", AAZ400='" + AAZ400 + '\'' +
                ", SBUUID='" + SBUUID + '\'' +
                ", AAB001='" + AAB001 + '\'' +
                ", AAB998='" + AAB998 + '\'' +
                ", AAB003='" + AAB003 + '\'' +
                ", AAB004='" + AAB004 + '\'' +
                ", AAB301='" + AAB301 + '\'' +
                ", AAE004='" + AAE004 + '\'' +
                ", AAE005='" + AAE005 + '\'' +
                ", AAE006='" + AAE006 + '\'' +
                ", AAE007='" + AAE007 + '\'' +
                ", AAB065='" + AAB065 + '\'' +
                ", AAE036='" + AAE036 + '\'' +
                ", AAA321='" + AAA321 + '\'' +
                ", AAA322='" + AAA322 + '\'' +
                ", AAE418='" + AAE418 + '\'' +
                ", AAE419='" + AAE419 + '\'' +
                ", AAE420='" + AAE420 + '\'' +
                ", AAE421='" + AAE421 + '\'' +
                ", AAE422='" + AAE422 + '\'' +
                ", AAE423='" + AAE423 + '\'' +
                ", AAE424='" + AAE424 + '\'' +
                ", AAE425='" + AAE425 + '\'' +
                ", AAE426='" + AAE426 + '\'' +
                '}';
    }
}
