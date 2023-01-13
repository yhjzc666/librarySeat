package com.spring.demo.service.impl;

import com.spring.demo.bean.User;
import com.spring.demo.dao.SysUserMapper;
import com.spring.demo.dao.WxUserMapper;
import com.spring.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuhaojie on 2022/12/31.
 * @version 1.0
 */
@Service
public class SysUserImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public User login(String UserName) {
        return sysUserMapper.login(UserName);
    }
}
