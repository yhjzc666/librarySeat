package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yhj
 * @description controller层
 * @date 2022/7/11 17:35
 */
@Controller
@RequestMapping(value = "/hello")
public class TestController {
    @RequestMapping(value = "/test")
    public String test() {
        return "index";
    }

}
