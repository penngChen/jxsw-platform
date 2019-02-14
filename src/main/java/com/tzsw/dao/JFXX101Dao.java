package com.tzsw.dao;

import com.tzsw.model.CBXX101;
import com.tzsw.model.DZXX101;
import com.tzsw.model.JFXX101;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 16:33 2018/11/30
 */
public interface JFXX101Dao {

    public void insertJFXX101(List<JFXX101> list);

    public List<JFXX101> findJFXX101(String JGBS);

    public void updateJFXX101(@Param("status") String status);

    public void deleteJFXX101ByDATABH(String DATABH);
}
