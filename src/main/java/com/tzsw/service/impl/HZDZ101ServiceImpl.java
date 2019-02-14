package com.tzsw.service.impl;

import com.tzsw.dao.HZDZ101Dao;
import com.tzsw.model.HZDZ101;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 15:04 2018/12/4
 */
@Slf4j
@Service
public class HZDZ101ServiceImpl {

    @Autowired
    private HZDZ101Dao hzdz101Dao;

    public void insertHZDZ101(List<HZDZ101> list) throws Exception {
        hzdz101Dao.insertHZDZ101(list);
    }

    public List<HZDZ101> findHZDZ101(String JGBS) throws Exception {
        return hzdz101Dao.findHZDZ101(JGBS);
    }

    @Transactional
    public void updateHZDZ101(String status) throws Exception {
        hzdz101Dao.updateHZDZ101(status);
    }

    public void deleteHZDZ101ByDATABH(String DATABH) throws Exception {
        hzdz101Dao.deleteHZDZ101ByDATABH(DATABH);
    }
}
