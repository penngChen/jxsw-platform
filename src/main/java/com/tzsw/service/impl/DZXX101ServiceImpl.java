package com.tzsw.service.impl;

import com.tzsw.dao.DZXX101Dao;
import com.tzsw.model.CBXX102;
import com.tzsw.model.DZXX101;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 15:05 2018/12/4
 */
@Slf4j
@Service
public class DZXX101ServiceImpl {

    @Autowired
    private DZXX101Dao dzxx101Dao;

    public void insertDZXX101(List<DZXX101> list) throws Exception {
        dzxx101Dao.insertDZXX101(list);
    }

    public List<DZXX101> findDZXX101(String JGBS) throws Exception {
        return dzxx101Dao.findDZXX101(JGBS);
    }

    @Transactional
    public void updateDZXX101(String status) throws Exception {
        dzxx101Dao.updateDZXX101(status);
    }

    public void deleteDZXX101ByDATABH(String DATABH) throws Exception {
        dzxx101Dao.deleteDZXX101ByDATABH(DATABH);
    }
}
