package com.spring.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.bean.Lists;
import com.spring.demo.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author yuhaojie on 2023/3/29.
 * @version 1.0
 */
@Controller
public class ListsController {
    @Autowired
    private ListsService listsService;
    @ResponseBody
    @RequestMapping(value = "/listsSelect")
    public Map ListsSelect(@RequestBody Lists lists){
        System.out.println(lists);
        List<Lists> ListsResult = listsService.listsSelect(lists);
        JSONObject object = new JSONObject();
        object.put("code", 200);
        object.put("msg", "查询成功!");
        object.put("seatDate", ListsResult);
        return object;
    }
}
