package com.tzsw.dao;

import com.tzsw.model.CBXX101;
import com.tzsw.model.JFXX101;
import com.tzsw.model.JFXX102;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 16:33 2018/11/30
 */
public interface JFXX102Dao {

    public void insertJFXX102(List<JFXX102> list);

    public List<JFXX102> findJFXX102(String JGBS);

    public void updateJFXX102(String status);

    public void deleteJFXX102ByDATABH(String DATABH);
}
