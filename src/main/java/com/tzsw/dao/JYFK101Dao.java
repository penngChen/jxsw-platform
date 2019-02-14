package com.tzsw.dao;

import com.tzsw.model.HZDZ101;
import com.tzsw.model.JYFK101;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:22 2018/12/3
 */
public interface JYFK101Dao {

    public void insertJYFK101(List<JYFK101> list);

    public List<JYFK101> findJYFK101(String JGBS);

    public void updateJYFK101(String status);

    public void deleteJYFK101ByDATABH(String DATABH);
}
