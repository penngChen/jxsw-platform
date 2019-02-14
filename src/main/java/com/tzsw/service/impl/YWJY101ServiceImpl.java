package com.tzsw.service.impl;

import com.tzsw.dao.YWJY101Dao;
import com.tzsw.model.YWJY101;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 15:06 2018/12/4
 */

@Service
@Slf4j
public class YWJY101ServiceImpl {

    @Autowired
    private YWJY101Dao ywjy101Dao;

    public void insertYWJY101(List<YWJY101> list) throws Exception {
        ywjy101Dao.insertYWJY101(list);
    }

    public List<YWJY101> findYWJY101(String JGBS) throws Exception {
        return ywjy101Dao.findYWJY101(JGBS);
    }

    @Transactional
    public void updateYWJY101(String status) throws Exception {
        ywjy101Dao.updateYWJY101(status);
    }

    public void deleteYWJY101ByDATABH(String DATABH) {
        ywjy101Dao.deleteYWJY101ByDATABH(DATABH);
    }
}
