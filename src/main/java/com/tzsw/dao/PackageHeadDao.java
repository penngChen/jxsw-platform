package com.tzsw.dao;

import com.tzsw.model.PackageHead;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 21:31 2018/12/3
 */
public interface PackageHeadDao {

    public void insertPackageHead(PackageHead packageHead);

    public List<PackageHead> findPackage();

    public void updatePackage(@Param("status") String status, @Param("DATABH") String DATABH);

    public void deletePackageHeadByDATABH(String DATABH);
}