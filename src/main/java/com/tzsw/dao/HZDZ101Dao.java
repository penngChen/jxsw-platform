package com.tzsw.dao;

import com.tzsw.model.CBXX102;
import com.tzsw.model.HZDZ101;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:22 2018/12/3
 */
public interface HZDZ101Dao {

    public void insertHZDZ101(List<HZDZ101> list);

    public List<HZDZ101> findHZDZ101(String JGBS);

    public void updateHZDZ101(String status);

    public void deleteHZDZ101ByDATABH(String DATABH);
}
