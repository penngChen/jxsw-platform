package com.tzsw.service.impl;

import com.tzsw.dao.JYFK101Dao;
import com.tzsw.model.JYFK101;
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
public class JYFK101ServiceImpl {

    @Autowired
    private JYFK101Dao jyfk101Dao;

    public void insertJYFK101(List<JYFK101> list) throws Exception {
        jyfk101Dao.insertJYFK101(list);
    }

    public List<JYFK101> findJYFK101(String JGBS) throws Exception {
        return jyfk101Dao.findJYFK101(JGBS);
    }

    @Transactional
    public void updateJYFK101(String status) throws Exception {
        jyfk101Dao.updateJYFK101(status);
    }

    public void deleteJYFK101ByDATABH(String DATABH) throws Exception {
        jyfk101Dao.deleteJYFK101ByDATABH(DATABH);
    }
}
