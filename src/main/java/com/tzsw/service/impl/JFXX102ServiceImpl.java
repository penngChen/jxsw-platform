package com.tzsw.service.impl;

import com.tzsw.dao.JFXX102Dao;
import com.tzsw.model.JFXX102;
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
public class JFXX102ServiceImpl {

    @Autowired
    private JFXX102Dao jfxx102Dao;

    public void insertJFXX102(List<JFXX102> list) throws Exception {
        jfxx102Dao.insertJFXX102(list);
    }

    public List<JFXX102> findJFXX102(String JGBS) throws Exception {
        return jfxx102Dao.findJFXX102(JGBS);
    }

    @Transactional
    public void updateJFXX102(String status) throws Exception {
        jfxx102Dao.updateJFXX102(status);
    }

    public void deleteJFXX102ByDATABH(String DATABH) throws Exception {
        jfxx102Dao.deleteJFXX102ByDATABH(DATABH);
    }
}
