package com.spring.demo.dao;

import com.spring.demo.bean.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 于浩杰
 * @Date: 2023/5/2 9:53
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
@Repository
public interface QuestionMapper {

    int InsertQuestion(Question question);

    List<Question> QuestionShow(Question question);

    List<Question> questionAllShow();

    int replyQuestion(Question question);
}
