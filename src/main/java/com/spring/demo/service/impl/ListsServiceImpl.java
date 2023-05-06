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

    @Override
    public List<Lists> listsALlSelect() {
        return listMapper.listsALlSelect();
    }

    @Override
    public int updateLists(String listId, String times, String listState) {
        return listMapper.updateLists(listId, times, listState);
    }

    @Override
    public List<Lists> listsSelectBookIng(Lists lists) {
        return listMapper.listsSelectBookIng(lists);
    }

    @Override
    public int updateListStates(Lists lists) {
        return listMapper.updateListStates(lists);
    }

    @Override
    public List<Lists> selectListStates(Lists lists) {
        return listMapper.selectListStates(lists);
    }

}
