package com.spring.demo.controller;

import com.spring.demo.bean.Goods;
import com.spring.demo.bean.User;
import com.spring.demo.service.impl.GoodsServiceImpl;
import com.spring.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author yuhaojie on 2022/7/16.
 * @version 1.0
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;
    /*
        获取商品列表
    */
    @ResponseBody
    @RequestMapping(value = "/getGoodsList")
    public Map getGoodsList() {
        List<Goods> GoodsList=goodsService.getGoodsList();

        //返回结果用
        Map<Object, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("data",GoodsList);
        return map;
    }
}
