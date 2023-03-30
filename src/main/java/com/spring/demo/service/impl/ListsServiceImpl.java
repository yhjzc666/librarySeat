package com.spring.demo.service.impl;

import com.spring.demo.bean.Lists;
import com.spring.demo.dao.ListMapper;
import com.spring.demo.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuhaojie on 2023/3/29.
 * @version 1.0
 */
@Service
public class ListsServiceImpl implements ListsService {

    @Autowired
    private ListMapper listMapper;
    @Override
    public List<Lists> listsSelect(Lists lists) {
        return listMapper.listsSelect(lists);
    }
}
