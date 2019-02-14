package com.tzsw.service.impl;

import com.tzsw.dao.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:32 2018/12/5
 */

@Service
public class sequenceServiceImpl {

    @Autowired
    private SequenceDao sequenceDao;

    public int getFileSeq() {
        return sequenceDao.getFileSeq();
    }

    public int getOperateSeq() {
        return sequenceDao.getOperateSeq();
    }

    public int getTZXX101IdSeq() {
        return sequenceDao.getTZXX101IdSeq();
    }
}
