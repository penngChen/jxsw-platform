package com.tzsw.dao;

import com.tzsw.model.YWJY101;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:22 2018/12/3
 */
public interface YWJY101Dao {

    public void insertYWJY101(List<YWJY101> list);

    public List<YWJY101> findYWJY101(String JGBS);

    public void updateYWJY101(String status);

    public void deleteYWJY101ByDATABH(String DATABH);
}
