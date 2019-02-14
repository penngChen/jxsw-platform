package com.tzsw.support;

import com.tzsw.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 15:35 2018/12/24
 */
@Lazy
public class SpringUtil {

    @Autowired
    public static CBXX101ServiceImpl cbxx101Service = SpringApplicationContextHolder.getBean(CBXX101ServiceImpl.class);

    @Autowired
    public static CBXX102ServiceImpl cbxx102Service = SpringApplicationContextHolder.getBean(CBXX102ServiceImpl.class);

    @Autowired
    public static JFXX101ServiceImpl jfxx101Service = SpringApplicationContextHolder.getBean(JFXX101ServiceImpl.class);

    @Autowired
    public static JFXX102ServiceImpl jfxx102Service = SpringApplicationContextHolder.getBean(JFXX102ServiceImpl.class);

    @Autowired
    public static HZDZ101ServiceImpl hzdz101Service = SpringApplicationContextHolder.getBean(HZDZ101ServiceImpl.class);

    @Autowired
    public static JYFK101ServiceImpl jyfk101Service = SpringApplicationContextHolder.getBean(JYFK101ServiceImpl.class);

    @Autowired
    public static DZXX101ServiceImpl dzxx101Service = SpringApplicationContextHolder.getBean(DZXX101ServiceImpl.class);

    @Autowired
    public static YWJY101ServiceImpl ywjy101Service = SpringApplicationContextHolder.getBean(YWJY101ServiceImpl.class);

    @Autowired
    public static SWDJ101ServiceImpl swdj101Service = SpringApplicationContextHolder.getBean(SWDJ101ServiceImpl.class);

    @Autowired
    public static SWDJ102ServiceImpl swdj102Service = SpringApplicationContextHolder.getBean(SWDJ102ServiceImpl.class);

    @Autowired
    public static PackageHeadServiceImpl packageHeadService = SpringApplicationContextHolder.getBean(PackageHeadServiceImpl.class);
}
