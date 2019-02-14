package com.tzsw.service.impl;

import com.tzsw.dao.CBXX102Dao;
import com.tzsw.model.CBXX102;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 11:24 2018/12/3
 */
@Service
@Slf4j
public class CBXX102ServiceImpl {

    @Autowired
    private CBXX102Dao cbxx102Dao;

    public void insertCBXX102(List<CBXX102> list) throws Exception {
        cbxx102Dao.insertCBXX102(list);
    }

    public List<CBXX102> findCBXX102(String JGBS) throws Exception {
        return cbxx102Dao.findCBXX102(JGBS);
    }

    @Transactional
    public void updateCBXX102(String status) throws Exception {
        cbxx102Dao.updateCBXX102(status);
    }

    public void deleteCBXX102ByDATABH(String DATABH) throws Exception {
        cbxx102Dao.deleteCBXX102ByDATABH(DATABH);
    }
}
