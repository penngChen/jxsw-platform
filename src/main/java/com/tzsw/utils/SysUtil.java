package com.tzsw.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;


/**
 * @Author: chenpeng
 * @Description:接口相关配置初始化
 * @Date: Created in 9:30 2018/11/22
 */
@Slf4j
public class SysUtil {
    private static SysUtil instanse = null;

    private static Properties pros = new Properties();


    /**
     * 私有构造函数
     */
    private SysUtil() {
        initProperties();

    }

    /**
     * 实例方法
     *
     * @return
     */
    public synchronized static SysUtil getInstanse() {
        if (instanse == null) {
            instanse = new SysUtil();
        }
        return instanse;
    }


    /**
     * 初始化系统配置
     */
    private void initProperties() {
        try {
            pros = PropertiesLoaderUtils.loadProperties(new ClassPathResource("META-INF/res/sys.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            log.error("初始化系统配置异常\n" + e);
        }
    }

    /**
     * @return
     */
    public String getPerperty(String name) {
        if (name == null || "".equals(name)) {
            return "";
        }
        String value = pros.getProperty(name);
        if (value == null || "".equals(value)) {
            return "";
        }
        return value;
    }
}