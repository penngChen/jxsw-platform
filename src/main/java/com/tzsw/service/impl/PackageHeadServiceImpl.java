package com.tzsw.service.impl;

import com.tzsw.dao.PackageHeadDao;
import com.tzsw.model.PackageHead;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 15:01 2018/12/4
 */
@Slf4j
@Service
public class PackageHeadServiceImpl {

    @Autowired
    private PackageHeadDao packageHeadDao;

    public void insertPackageHead(PackageHead packageHead) throws Exception {
        packageHeadDao.insertPackageHead(packageHead);
    }

    public List<PackageHead> findPackage() throws Exception {
        return packageHeadDao.findPackage();
    }

    @Transactional
    public void updatePackage(String status, String DATABH) throws Exception {
        packageHeadDao.updatePackage(status, DATABH);
    }

    public void deletePackageHeadByDATABH(String DATABH) throws Exception {
        packageHeadDao.deletePackageHeadByDATABH(DATABH);
    }
}
