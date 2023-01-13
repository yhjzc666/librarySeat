package com.spring.demo.controller;

/**
 * @author yuhaojie on 2022/12/31.
 * @version 1.0
 */

import com.spring.demo.bean.Systems;
import com.spring.demo.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class SystemController {
    @Autowired
    private SystemService systemService;

    @ResponseBody
    @RequestMapping(value = "/updateState")
    public Map updateSate(@RequestBody String state){
        int reslut = systemService.updateState(state);
        System.out.println(reslut);
        Map<Object,String> map = new HashMap<>();
        if(reslut == 1){
            map.put("code","200");
            map.put("state",state);
        }
        return map;
    }
}
