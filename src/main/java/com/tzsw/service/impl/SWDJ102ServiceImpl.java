package com.tzsw.service.impl;

import com.tzsw.dao.SWDJ102Dao;
import com.tzsw.model.SWDJ102;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 9:46 2018/12/6
 */

@Service
public class SWDJ102ServiceImpl {

    @Autowired
    private SWDJ102Dao swdj102Dao;

    public void insertSWDJ102(List<SWDJ102> list) throws Exception {
        swdj102Dao.insertSWDJ102(list);
    }

    public List<SWDJ102> findSWDJ102(String JGBS) throws Exception {
        return swdj102Dao.findSWDJ102(JGBS);
    }

    @Transactional
    public void updateSWDJ102(String status) throws Exception {
        swdj102Dao.updateSWDJ102(status);
    }

    public void deleteSWDJ102ByDATABH(String DATABH) throws Exception {
        swdj102Dao.deleteSWDJ102ByDATABH(DATABH);
    }
}
