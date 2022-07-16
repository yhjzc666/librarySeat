package com.spring.demo.service.impl;

import com.spring.demo.bean.Goods;
import com.spring.demo.dao.GoodsMapper;
import com.spring.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuhaojie on 2022/7/16.
 * @version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public List<Goods> getGoodsList() {
        return goodsMapper.getGoodsList();
    }
}
