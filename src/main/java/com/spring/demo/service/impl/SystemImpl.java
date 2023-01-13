package com.spring.demo.service.impl;

import com.spring.demo.dao.SystemMapper;
import com.spring.demo.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuhaojie on 2022/12/31.
 * @version 1.0
 */
@Service
public class SystemImpl implements SystemService {

    @Autowired
    private SystemMapper systemMapper;
    @Override
    public int updateState(String state) {

        return systemMapper.updateState(state);
    }
}
