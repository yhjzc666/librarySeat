package com.spring.demo.service.impl;

import com.spring.demo.bean.Question;
import com.spring.demo.dao.QuestionMapper;
import com.spring.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 于浩杰
 * @Date: 2023/5/2 9:51
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int InsertQuestion(Question question) {
        return questionMapper.InsertQuestion(question);
    }

    @Override
    public List<Question> QuestionShow(Question question) {
        return questionMapper.QuestionShow(question);
    }

    @Override
    public List<Question> questionAllShow() {
        return questionMapper.questionAllShow();
    }

    @Override
    public int replyQuestion(Question question) {
        return questionMapper.replyQuestion(question);
    }
}
