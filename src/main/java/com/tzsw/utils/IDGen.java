package com.tzsw.utils;

import java.util.UUID;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:51 2018/11/5
 */
public class IDGen {

    /**
     * 创建32位的UUID
     *
     * @return
     */
    public static String createUUID32() {
        return createUUID36().replaceAll("-", "");
    }

    /**
     * 创建36位的UUID
     *
     * @return
     */
    public static String createUUID36() {
        return UUID.randomUUID().toString();
    }
}
