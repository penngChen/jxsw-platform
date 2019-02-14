package com.tzsw.dao;

import com.tzsw.model.CBXX102;
import com.tzsw.model.DZXX101;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:22 2018/12/3
 */
public interface DZXX101Dao {

    public void insertDZXX101(List<DZXX101> list);

    public List<DZXX101> findDZXX101(String JGBS);

    public void updateDZXX101(String status);

    public void deleteDZXX101ByDATABH(String DATABH);
}
