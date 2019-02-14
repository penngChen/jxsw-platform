package com.tzsw.dao;

import com.tzsw.model.CBXX101;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 16:33 2018/11/30
 */
public interface CBXX101Dao {

    public void insertCBXX101(List<CBXX101> list);

    public List<CBXX101> findCBXX101(String JGBS);

    public void updateCBXX101(String status);

    public void deleteCBXX101ByDATABH(String DATABH);
}
