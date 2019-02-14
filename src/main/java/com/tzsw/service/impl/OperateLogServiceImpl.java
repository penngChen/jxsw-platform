package com.tzsw.service.impl;

import com.tzsw.dao.OperateLogDao;
import com.tzsw.model.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 16:42 2018/12/6
 */
@Service
public class OperateLogServiceImpl {

    @Autowired
    private OperateLogDao operateLogDao;

    public void insertOperateLog(OperateLog operateLog) {
        try {
            operateLogDao.insertOperateLog(operateLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
