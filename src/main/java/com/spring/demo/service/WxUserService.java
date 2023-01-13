package com.spring.demo.service;

import com.spring.demo.bean.WxUser;

/**
 * @author yuhaojie on 2022/11/7.
 * @version 1.0
 */
public interface WxUserService {
    WxUser queryByOpenId(String openId);

    void insertUser(WxUser wxUser);

    int updateUser(WxUser wxUser);

}
