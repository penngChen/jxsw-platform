package com.tzsw.support;

import com.tzsw.service.impl.*;
import com.tzsw.utils.SysUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 15:48 2018/11/26
 */
@Lazy
public class Constant {

    public static final String SENDRSGXXX_ADDRESS = SysUtil.getInstanse().getPerperty("sendRsGxxx.address");

    public static final String SENDRSGXXX_NAMESPACE = SysUtil.getInstanse().getPerperty("sendRsGxxx.namespace");

    public static final String TZXX001CODE = "TZXX001";

    public static final String TZXX101CODE = "TZXX101";

    public static final String SFTP_URL = "/sftpsstax/sstax_";

    public static final String BUSINESS_URL = "/rs2sw";

    public static final String PLATFORM_URL = "/sw2rs/";

    public static final String DOWNLOAN_URL = "/home/weblogic/webapps/sftp/";

    public static final String ISSFCF = "1";

    public static final String JGBS_GZ = "3607004000";

    public static final String JGBS_JA = "3608004000";

    public static final String JGBS_FZ = "3610004000";

    public static final String JGBS_SR = "3611004000";

    public static final String HOST = "10.104.17.229";

    public static final int PORT = 254;

    public static final String USERNAME = "sstax_";

    public static final String PASSWORD_TEST = "sstaxtest";

    public static final String PASSWORD_GZ = "sstax_Eg%";

    public static final String PASSWORD_JA = "sstax_NSP";

    public static final String PASSWORD_FZ = "sstax_0L1";

    public static final String PASSWORD_SR = "sstax_7ma";

    public static final String FZ_ADDRESS = SysUtil.getInstanse().getPerperty("fz.address");

    public static final String FZ_NAMESPACE = SysUtil.getInstanse().getPerperty("fz.namespace");

    public static final String GZ_ADDRESS = SysUtil.getInstanse().getPerperty("gz.address");

    public static final String GZ_NAMESPACE = SysUtil.getInstanse().getPerperty("gz.namespace");

    public static final String JA_ADDRESS = SysUtil.getInstanse().getPerperty("ja.address");

    public static final String JA_NAMESPACE = SysUtil.getInstanse().getPerperty("ja.namespace");

    public static final String SR_ADDRESS = SysUtil.getInstanse().getPerperty("sr.address");

    public static final String SR_NAMESPACE = SysUtil.getInstanse().getPerperty("sr.namespace");

    public static final String SCHEDULR_CRON = SysUtil.getInstanse().getPerperty("schedulr.cron");

    public static final String CHARSET_NAME = "GBK";

    public static String XMLFileHeader = "<?xml version=\"1.0\" encoding=\"GBK\"?><Package>";
}
