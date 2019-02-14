package com.tzsw.service.impl;

import com.tzsw.dao.JFXX101Dao;
import com.tzsw.model.JFXX101;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 15:02 2018/12/4
 */
@Slf4j
@Service
public class JFXX101ServiceImpl {

    @Autowired
    private JFXX101Dao jfxx101Dao;

    public void insertJFXX101(List<JFXX101> list) throws Exception {
        jfxx101Dao.insertJFXX101(list);
    }

    public List<JFXX101> findJFXX101(String JGBS) throws Exception {
        return jfxx101Dao.findJFXX101(JGBS);
    }

    @Transactional
    public void updateJFXX101(String status) throws Exception {
        jfxx101Dao.updateJFXX101(status);
    }

    public void deleteJFXX101ByDATABH(String DATABH) throws Exception {
        jfxx101Dao.deleteJFXX101ByDATABH(DATABH);
    }
}
