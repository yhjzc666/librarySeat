package com.spring.demo.dao;

import com.spring.demo.bean.Lists;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yuhaojie on 2023/3/26.
 * @version 1.0
 */
@Mapper
@Repository
public interface ListMapper {
    int bookList(Map inf);

    List<Lists> getLists(Map inf);

    List<Lists> listsSelect(Lists lists);

    List<Lists> listsALlSelect();

    int updateLists(String listId, String times, String listState);

    List<Lists> listsSelectBookIng(Lists lists);

    int updateListStates(Lists lists);

    List<Lists> selectListStates(Lists lists);
}
