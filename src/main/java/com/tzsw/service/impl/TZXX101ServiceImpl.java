package com.tzsw.service.impl;

import com.tzsw.dao.TZXX101Dao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:30 2018/12/17
 */
@Service
@Slf4j
public class TZXX101ServiceImpl {

    @Autowired
    private TZXX101Dao tzxx101Dao;

    public void insertTZXX101(Map<String, String> map) {
        try {
            tzxx101Dao.insertTZXX101(map);
        } catch (Exception e) {
            log.error("插入通知信息失败：" + e.getMessage());
        }
    }
}
