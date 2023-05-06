package com.spring.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.bean.Question;
import com.spring.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * @Author: 于浩杰
 * @Date: 2023/5/2 9:48
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @ResponseBody
    @RequestMapping(value = "/QuestionSubmit")
    public Object questionSubmit(@RequestBody Question question) {
        JSONObject objectObjectMap = new JSONObject();
        question.setID(UUID.randomUUID().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Subtime = sdf.format(System.currentTimeMillis());
        question.setSubTime(Subtime);
        question.setState("1");//1、已提交 2、已回复 3、已撤回
        int num = questionService.InsertQuestion(question);
        if (num == 1) {
            objectObjectMap.put("code", "200");
            objectObjectMap.put("msg", "提交成功");
        }
        return objectObjectMap;
    }

    @ResponseBody
    @RequestMapping(value = "/QuestionShow")
    public Object questionShow(@RequestBody Question question) {
        JSONObject objectObjectMap = new JSONObject();
        List<Question> num = questionService.QuestionShow(question);
        objectObjectMap.put("code", "200");
        objectObjectMap.put("msg", "提交成功");
        objectObjectMap.put("result", num);
        return objectObjectMap;
    }

    @ResponseBody
    @RequestMapping(value = "/questionAllShow")
    public Object questionAllShow() {
        JSONObject objectObjectMap = new JSONObject();
        List<Question> num = questionService.questionAllShow();
        for (Question lists : num
        ) {
            if ("1".equals(lists.getState())) {
                lists.setState("已提交");
                lists.setRepTime("等待回复中");
            } else if ("2".equals(lists.getState())) {
                lists.setState("已回复");
            }
        }
        objectObjectMap.put("code", "200");
        objectObjectMap.put("msg", "提交成功");
        objectObjectMap.put("result", num);
        return objectObjectMap;
    }

    @ResponseBody
    @RequestMapping(value = "/replyQuestion")
    public Object replyQuestion(@RequestBody Question question) {
        JSONObject objectObjectMap = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Reptime = sdf.format(System.currentTimeMillis());
        question.setRepTime(Reptime);
        int num = questionService.replyQuestion(question);
        objectObjectMap.put("code", "200");
        objectObjectMap.put("msg", "提交成功");
        return objectObjectMap;
    }
}
