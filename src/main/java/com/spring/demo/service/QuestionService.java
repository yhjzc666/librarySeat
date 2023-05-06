package com.spring.demo.service;

import com.spring.demo.bean.Question;

import java.util.List;

/**
 * @Author: 于浩杰
 * @Date: 2023/5/2 9:50
 * @Version: v1.0.0
 * @Description: TODO
 **/

public interface QuestionService {
    int InsertQuestion(Question question);

    List<Question> QuestionShow(Question question);

    List<Question> questionAllShow();

    int replyQuestion(Question question);
}
