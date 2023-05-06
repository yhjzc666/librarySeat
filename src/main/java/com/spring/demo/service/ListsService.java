package com.spring.demo.service;

import com.spring.demo.bean.Lists;

import java.util.List;

/**
 * @author yuhaojie on 2023/3/29.
 * @version 1.0
 */
public interface ListsService {
    List<Lists> listsSelect(Lists lists);

    List<Lists> listsALlSelect();

    int updateLists(String listId, String times, String listState);

    List<Lists> listsSelectBookIng(Lists lists);

    int updateListStates(Lists lists);

    List<Lists> selectListStates(Lists lists);
}
