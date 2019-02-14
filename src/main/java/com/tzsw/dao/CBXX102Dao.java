package com.tzsw.dao;

import com.tzsw.model.CBXX101;
import com.tzsw.model.CBXX102;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:22 2018/12/3
 */
public interface CBXX102Dao {

    public void insertCBXX102(List<CBXX102> list);

    public List<CBXX102> findCBXX102(String JGBS);

    public void updateCBXX102(String status);

    public void deleteCBXX102ByDATABH(String DATABH);
}
