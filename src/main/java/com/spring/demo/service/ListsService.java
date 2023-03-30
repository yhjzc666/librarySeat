package com.spring.demo.service;

import com.spring.demo.bean.Lists;

import java.util.List;

/**
 * @author yuhaojie on 2023/3/29.
 * @version 1.0
 */
public interface ListsService {
    List<Lists> listsSelect(Lists lists);
}
