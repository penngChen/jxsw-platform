package com.tzsw.dao;

import com.tzsw.model.SWDJ101;
import com.tzsw.model.SWDJ102;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 9:32 2018/12/6
 */
public interface SWDJ102Dao {

    public void insertSWDJ102(List<SWDJ102> list);

    public List<SWDJ102> findSWDJ102(String JGBS);

    public void updateSWDJ102(String status);

    public void deleteSWDJ102ByDATABH(String DATABH);
}
