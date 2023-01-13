package com.spring.demo.service;

import com.spring.demo.bean.User;

/**
 * @author yuhaojie on 2022/12/31.
 * @version 1.0
 */
public interface SysUserService {
    User login(String UserName);
}
