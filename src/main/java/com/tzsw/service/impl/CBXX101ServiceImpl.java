package com.tzsw.service.impl;

import com.tzsw.dao.CBXX101Dao;
import com.tzsw.model.CBXX101;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 9:17 2018/12/3
 */
@Service
@Slf4j
public class CBXX101ServiceImpl {

    @Autowired
    private CBXX101Dao cbxx101Dao;

    public void insertCBXX101(List<CBXX101> list) throws Exception {
        cbxx101Dao.insertCBXX101(list);
    }

    public List<CBXX101> findCBXX101(String JGBS) throws Exception {
        return cbxx101Dao.findCBXX101(JGBS);
    }

    @Transactional
    public void updateCBXX101(String status) throws Exception {
        cbxx101Dao.updateCBXX101(status);
    }

    public void deleteCBXX101ByDATABH(String DATABH) throws Exception {
        cbxx101Dao.deleteCBXX101ByDATABH(DATABH);
    }
}
