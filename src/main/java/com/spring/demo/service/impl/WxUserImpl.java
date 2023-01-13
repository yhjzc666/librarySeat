package com.spring.demo.service.impl;

import com.spring.demo.bean.WxUser;
import com.spring.demo.dao.WxUserMapper;
import com.spring.demo.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuhaojie on 2022/11/7.
 * @version 1.0
 */
@Service
public class WxUserImpl implements WxUserService {
    @Autowired
    private WxUserMapper wxuserMapper;

    @Override
    public WxUser queryByOpenId(String openId) {

        return wxuserMapper.queryByOpenId(openId);
    }

    @Override
    public void insertUser(WxUser wxUser) {
        wxuserMapper.insertUser(wxUser);

    }

    @Override
    public int updateUser(WxUser wxUser) {
        return wxuserMapper.updateUser(wxUser);

    }
}
