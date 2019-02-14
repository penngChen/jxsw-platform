package com.tzsw.service;

import com.jcraft.jsch.ChannelSftp;
import com.tzsw.model.*;
import com.tzsw.model.receive.PackageHeadR;
import com.tzsw.service.impl.*;
import com.tzsw.support.Constant;
import com.tzsw.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 16:25 2018/11/16
 */
@Slf4j
@WebService(serviceName = "WebServiceAll", targetNamespace = "http://service.zjtzsw.com/",
        endpointInterface = "com.tzsw.service.WebServiceAll")
@Component
public class WebServiceImpl extends BaseService implements WebServiceAll {


    private sequenceServiceImpl sequenceService;

    @Autowired
    public void setSequenceService(sequenceServiceImpl sequenceService) {
        this.sequenceService = sequenceService;
    }

    private static ExecutorService parsePool = Executors.newCachedThreadPool();

    private TZXX101ServiceImpl tzxx101Service;

    @Autowired
    public void setTzxx101Service(TZXX101ServiceImpl tzxx101Service) {
        this.tzxx101Service = tzxx101Service;
    }

    @Autowired
    public void setOperateLogService(OperateLogServiceImpl operateLogService) {
        this.operateLogService = operateLogService;
    }

    private OperateLogServiceImpl operateLogService;

    @Override
    public String receiveSwGxxx(String servicecode, String busipacket) {
        log.info("Tax platform receives data: servicecode=" + servicecode + ">>>>>>>>>busipacket=" + busipacket);
        PackageHead packageHead = LookupUtil.getAllPackageHead(busipacket);
        String sjbbh = packageHead.getSJBBH();
        String jgbs = packageHead.getJGBS();
        PackageHeadR packageHeadR = new PackageHeadR();
        packageHeadR.setSJBLX("SSHZ001");
        packageHeadR.setSJBBH(sjbbh);
        packageHeadR.setJGBS(jgbs);
        packageHeadR.setSCRQ(packageHead.getSCRQ());
        packageHeadR.setDWDM(packageHead.getDWDM());
        packageHeadR.setDWMC(packageHead.getDWMC());
        if (isValidateParams(servicecode, busipacket)) {
            if (servicecode.equals(Constant.TZXX101CODE)) {
                Map<String, String> map = LookupUtil.getTZXX101(busipacket);
                String tzxx101Id = DateUtil.formatDate(new Date()) + CommonUtil.frontCompWithZore(sequenceService.getTZXX101IdSeq(), 6);
                map.put("TZXX101ID", tzxx101Id);
                tzxx101Service.insertTZXX101(map);
                String filePath = map.get("FILEPATH");
                String fileName = map.get("FILENAME");
                if (!StringUtils.isBlank(filePath) && !StringUtils.isBlank(fileName)) {
                    parsePool.execute(new Runnable() {
                        @Override
                        public void run() {
                            ChannelSftp sftp = SFTPUtil.connectWhichone(jgbs);
                            if (sftp != null) {
                                String result = SFTPUtil.readSftp(sftp, filePath, fileName);
                                log.info("Read notification information from TZXX101: " + result);
                                SFTPUtil.disconnect(sftp);
                                if (!StringUtils.isBlank(result)) {
                                    LookupUtil.paseXmlByString(result);
                                }
                            }
                        }
                    });
                    packageHeadR.setRECODE_ZT("0");
                    packageHeadR.setREMSG_ZT("成功");
                    return XstreamUtils.getSSYWOrTZXX(packageHeadR, sjbbh, "0", "文件下载成功");
                } else {
                    packageHeadR.setRECODE_ZT("1");
                    packageHeadR.setREMSG_ZT("失败");
                    return XstreamUtils.getSSYWOrTZXX(packageHeadR, sjbbh, "1", "文件下载失败");
                }
            } else {
                packageHeadR.setRECODE_ZT("0");
                packageHeadR.setREMSG_ZT("成功");
                parsePool.execute(new Runnable() {
                    @Override
                    public void run() {
                        LookupUtil.paseXmlByString(busipacket);
                    }
                });
                return XstreamUtils.getSSYWOrTZXX(packageHeadR, sjbbh, "0", "报文接收成功");
            }
        } else {
            packageHeadR.setRECODE_ZT("1");
            packageHeadR.setREMSG_ZT("失败");
            return XstreamUtils.getSSYWOrTZXX(packageHeadR, sjbbh, "1", "报文接收失败");
        }

    }

    @Override
    public String receiveBusiness(String servicecode, String busipacket) {
        log.info("Service system interface request parameter :servicecode=" + servicecode + ">>>>>>>>>busipacket=" + busipacket);
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateID(DateUtil.formatDate(new Date()) + CommonUtil.frontCompWithZore(sequenceService.getOperateSeq(), 6));
        operateLog.setServiceCode(servicecode);
        operateLog.setOperateType("2");
        if (isValidateParams(servicecode, busipacket)) {
            if (servicecode.equals(Constant.TZXX001CODE)) {
                PackageHead packageHead1 = LookupUtil.getAllPackageHead(busipacket);
                String jgbs = packageHead1.getJGBS();
                String directory = "/" + DateUtil.formatDate(new Date());
                String fileName = "SBF_" + packageHead1.getSJBLX() + "_" + jgbs + packageHead1.getSJBBH().substring(0, 6) + DateUtil.formatDate(new Date()) + CommonUtil.frontCompWithZore(sequenceService.getFileSeq(), 6) + ".xml";
                String sendResult = XstreamUtils.getTZXX001(packageHead1, fileName, directory);
                log.info("Package data by TZXX001：" + sendResult);
                ChannelSftp sftp = SFTPUtil.connectWhichone(jgbs);
                if (sftp != null) {
                    String path = Constant.SFTP_URL + jgbs + Constant.BUSINESS_URL;
                    boolean flag = SFTPUtil.upload(sftp, path + directory, busipacket, fileName);
                    SFTPUtil.disconnect(sftp);
                    if (flag) {
                        String results = SimpleWSClientUtil.invokesendRsGxxx2(servicecode, sendResult);
                        operateLog.setBusipacket(results);
                        operateLogService.insertOperateLog(operateLog);
                        return results;
                    }
                }
            } else {
                String results = SimpleWSClientUtil.invokesendRsGxxx2(servicecode, busipacket);
                operateLog.setBusipacket(results);
                operateLogService.insertOperateLog(operateLog);
                return results;
            }
        }
        return "";
    }

    @Override
    public String receiveTest(String account, String fileName, String date) {
        log.info("Test call interface starts>>>>>>>>>：");
        ChannelSftp sftp = SFTPUtil.connectWhichone(account);
        String path = Constant.SFTP_URL + account + Constant.PLATFORM_URL + date;
        boolean flag = SFTPUtil.download(sftp, path, fileName, Constant.DOWNLOAN_URL + fileName);
        SFTPUtil.disconnect(sftp);
        if (flag) {
            return "true";
        }
        return "false";
    }
}