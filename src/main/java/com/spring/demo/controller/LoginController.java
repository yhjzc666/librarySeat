package com.spring.demo.controller;

import com.spring.demo.bean.User;
import com.spring.demo.util.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yuhaojie on 2022/7/15.
 * @version 1.0
 */
@Controller
public class LoginController {
    @ResponseBody
    @RequestMapping(value = "/login")
    public Map login(@RequestBody User user) {
        //生成token用
        Map<String, Object> info = new HashMap<>();
        info.put("username", user.getUsername());
        info.put("pass", user.getPassword());
        String userId = UUID.randomUUID().toString();
        String token = JwtUtil.sign(userId, info);

        //返回结果用
        Map<Object, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("token", token);
        return map;
    }
}
