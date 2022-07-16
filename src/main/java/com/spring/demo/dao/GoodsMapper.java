package com.spring.demo.dao;

import com.spring.demo.bean.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yuhaojie on 2022/7/16.
 * @version 1.0
 */
@Component(value = "GoodsDao")
@Mapper
public interface GoodsMapper {
    List<Goods> getGoodsList();
}
