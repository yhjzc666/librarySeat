package com.spring.demo.dao;

import com.spring.demo.bean.Bull;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 于浩杰
 * @Date: 2023/4/9 15:49
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
@Repository
public interface BullMapper {
    List<Bull> bullSelect();

    int insertBulls(Bull bull);
}
