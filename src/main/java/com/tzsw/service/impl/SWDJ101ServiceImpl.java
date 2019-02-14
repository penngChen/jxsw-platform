package com.tzsw.service.impl;

import com.tzsw.dao.SWDJ101Dao;
import com.tzsw.model.SWDJ101;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 9:44 2018/12/6
 */
@Service
public class SWDJ101ServiceImpl {

    @Autowired
    private SWDJ101Dao swdj101Dao;

    public void insertSWDJ101(List<SWDJ101> list) throws Exception {
        swdj101Dao.insertSWDJ101(list);
    }

    public List<SWDJ101> findSWDJ101(String JGBS) throws Exception {
        return swdj101Dao.findSWDJ101(JGBS);
    }

    @Transactional
    public void updateSWDJ101(String status) throws Exception {
        swdj101Dao.updateSWDJ101(status);
    }

    public void deleteSWDJ101ByDATABH(String DATABH) throws Exception {
        swdj101Dao.deleteSWDJ101ByDATABH(DATABH);
    }
}
