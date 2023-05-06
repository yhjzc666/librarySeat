package com.spring.demo.service.impl;

import com.spring.demo.bean.Bull;
import com.spring.demo.dao.BullMapper;
import com.spring.demo.service.BullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 于浩杰
 * @Date: 2023/4/9 15:49
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Service
public class BullServiceImpl implements BullService {
    @Autowired
    private BullMapper bullMapper;

    @Override
    public List<Bull> bullSelect() {
        return bullMapper.bullSelect();
    }

    @Override
    public int insertBulls(Bull bull) {
        return bullMapper.insertBulls(bull);
    }
}
