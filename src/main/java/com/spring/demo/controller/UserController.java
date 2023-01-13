package com.spring.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.bean.Student;
import com.spring.demo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author yuhaojie on 2023/1/9.
 * @version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private StuService stuService;

    //添加学生信息
    @ResponseBody
    @RequestMapping(value = "/insertStu")
    public Map InsertStu(@RequestBody Student stu) {
        JSONObject object = new JSONObject();
        Student result = stuService.selectStu(stu);
        if (result != null) {
            object.put("code", 300);
            object.put("msg", "添加失败!");
            return object;
        }
        if (stu.getState().equals("正常")) {
            stu.setState("1");//正常
        } else {
            stu.setState("2");//暂封
        }
        stu.setTime(String.valueOf(System.currentTimeMillis()));
        int num = stuService.insertStu(stu);
        if (num == 1) {
            object.put("code", 200);
            object.put("msg", "添加成功!");
            object.put("userInfo", stu);
        } else {
            object.put("code", 400);
            object.put("msg", "添加失败!");
        }
        return object;
    }

    @ResponseBody
    @RequestMapping(value = "/selectStu")
    public Map SelectStu() {
        JSONObject object = new JSONObject();
        object.put("code", 200);
        object.put("msg", "查询成功!");
        List<Student> result = stuService.selectStuAll();
        object.put("stuDate", result);
        return object;
    }
}
