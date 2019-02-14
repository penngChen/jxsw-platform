package com.tzsw.utils;

import com.tzsw.model.PackageHead;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 10:17 2018/12/4
 */
public class CommonUtil {

    /*
     * @Description 左侧补零
     * @Param sourceDate 源数据
     * @Param formatLength 总长度
     * @return
     **/

    public static String frontCompWithZore(int sourceDate, int formatLength) {
        return String.format("%0" + formatLength + "d", sourceDate);
    }
}
