package com.tzsw.dao;

import com.tzsw.model.JFXX101;
import com.tzsw.model.SWDJ101;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 9:29 2018/12/6
 */
public interface SWDJ101Dao {

    public void insertSWDJ101(List<SWDJ101> list);

    public List<SWDJ101> findSWDJ101(String JGBS);

    public void updateSWDJ101(String status);

    public void deleteSWDJ101ByDATABH(String DATABH);
}
