package com.spring.demo.service;

import com.spring.demo.bean.Bull;

import java.util.List;

/**
 * @Author: 于浩杰
 * @Date: 2023/4/9 15:46
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface BullService {
    List<Bull> bullSelect();

    int insertBulls(Bull bull);
}
