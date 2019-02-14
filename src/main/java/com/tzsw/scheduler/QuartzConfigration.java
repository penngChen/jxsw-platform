package com.tzsw.scheduler;

import com.tzsw.support.Constant;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:58 2018/11/21
 */

@Configuration
public class QuartzConfigration {

    /**
     * 配置任务
     *
     * @return
     */
    @Bean(name = "reptilianJob")
    public JobDetailFactoryBean detailFactoryBean() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        Map<String, Integer> map = new HashMap<>();
        map.put("timeout", 5);
        jobDetail.setJobClass(QuartzTask.class);
        jobDetail.setDurability(true);
        jobDetail.setJobDataAsMap(map);
        return jobDetail;
    }

    /**
     * 定时触发器
     *
     * @param reptilianJob 任务
     * @return
     */
    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(JobDetail reptilianJob) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(reptilianJob);
        //cron表达式，每天0点 12点各执行一次
//        tigger.setCronExpression("0 0 0,12 * * ? ");
        tigger.setCronExpression(Constant.SCHEDULR_CRON);
        return tigger;
    }

    /**
     * 调度工厂
     *
     * @param jobTrigger 触发器
     * @return
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger jobTrigger) {

        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

        Resource resource = new ClassPathResource("META-INF/res/quartz.properties");
        factoryBean.setConfigLocation(resource);

        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);

        // 延时启动，应用启动1秒后
        factoryBean.setStartupDelay(30);

        // 注册触发器
        factoryBean.setTriggers(jobTrigger);

        return factoryBean;
    }
}
