package com.tzsw.scheduler;

import com.tzsw.model.*;
import com.tzsw.support.SpringUtil;
import com.tzsw.utils.SimpleWSClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:21 2018/11/21
 */

@Slf4j
@DisallowConcurrentExecution
@Lazy
public class QuartzTask implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("调度器开始执行>>>>>>>>>>>>>");
        Long l1 = System.currentTimeMillis();
        try {
            List<PackageHead> packageHeadList = SpringUtil.packageHeadService.findPackage();
            if (packageHeadList != null && !packageHeadList.isEmpty()) {
                SpringUtil.packageHeadService.updatePackage("1", "");
                for (PackageHead packageHead : packageHeadList) {
                    String sjblx = packageHead.getSJBLX();
                    String jgbs = packageHead.getJGBS();
                    switch (sjblx) {
                        case "JFXX101":
                            List<JFXX101> jfxx101List = SpringUtil.jfxx101Service.findJFXX101(jgbs);
                            if (jfxx101List != null && !jfxx101List.isEmpty()) {
                                SpringUtil.jfxx101Service.updateJFXX101("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, jfxx101List);
                            }
                            continue;
                        case "JFXX102":
                            List<JFXX102> jfxx102List = SpringUtil.jfxx102Service.findJFXX102(jgbs);
                            if (jfxx102List != null && !jfxx102List.isEmpty()) {
                                SpringUtil.jfxx102Service.updateJFXX102("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, jfxx102List);
                            }
                            continue;
                        case "HZDZ101":
                            List<HZDZ101> hzdz101List = SpringUtil.hzdz101Service.findHZDZ101(jgbs);
                            if (hzdz101List != null && !hzdz101List.isEmpty()) {
                                SpringUtil.hzdz101Service.updateHZDZ101("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, hzdz101List);
                            }
                            continue;
                        case "JYFK101":
                            List<JYFK101> jyfk101List = SpringUtil.jyfk101Service.findJYFK101(jgbs);
                            if (jyfk101List != null && !jyfk101List.isEmpty()) {
                                SpringUtil.jyfk101Service.updateJYFK101("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, jyfk101List);
                            }
                            continue;
                        case "YWJY101":
                            List<YWJY101> ywjy101List = SpringUtil.ywjy101Service.findYWJY101(jgbs);
                            if (ywjy101List != null && !ywjy101List.isEmpty()) {
                                SpringUtil.ywjy101Service.updateYWJY101("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, ywjy101List);
                            }
                            continue;
                        case "SWDJ101":
                            List<SWDJ101> swdj101List = SpringUtil.swdj101Service.findSWDJ101(jgbs);
                            if (swdj101List != null && !swdj101List.isEmpty()) {
                                SpringUtil.swdj101Service.updateSWDJ101("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, swdj101List);
                            }
                            continue;
                        case "SWDJ102":
                            List<SWDJ102> swdj102List = SpringUtil.swdj102Service.findSWDJ102(jgbs);
                            if (swdj102List != null && !swdj102List.isEmpty()) {
                                SpringUtil.swdj102Service.updateSWDJ102("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, swdj102List);
                            }
                            continue;
                        case "DZXX101":
                            List<DZXX101> dzxx101List = SpringUtil.dzxx101Service.findDZXX101(jgbs);
                            if (dzxx101List != null && !dzxx101List.isEmpty()) {
                                SpringUtil.dzxx101Service.updateDZXX101("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, dzxx101List);
                            }
                            continue;
                        case "CBXX101":
                            List<CBXX101> cbxx101List = SpringUtil.cbxx101Service.findCBXX101(jgbs);
                            if (cbxx101List != null && !cbxx101List.isEmpty()) {
                                SpringUtil.cbxx101Service.updateCBXX101("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, cbxx101List);
                            }
                            continue;
                        case "CBXX102":
                            List<CBXX102> cbxx102List = SpringUtil.cbxx102Service.findCBXX102(jgbs);
                            if (cbxx102List != null && !cbxx102List.isEmpty()) {
                                SpringUtil.cbxx102Service.updateCBXX102("1");
                                SimpleWSClientUtil.invokeAllCity(jgbs, sjblx, cbxx102List);
                            }
                        default:
                            break;
                    }
                }
            }
            Long l2 = System.currentTimeMillis();
            log.info("调度器执行完毕>>>>>>>>>>>>>用时(s)：" + (float) (l2 - l1) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("调度器执行出错：" + e.getMessage());
        }
    }
}
