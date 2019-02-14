package com.tzsw.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:28 2018/11/22
 */
public class BaseService {

    /**
     * 验证参数是否为空
     *
     * @param params
     * @return
     */
    public boolean isValidateParams(String... params) {
        for (String param : params) {
            if (StringUtils.isBlank(param)) {
                return false;
            }
        }
        return true;
    }
}
