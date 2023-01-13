package com.spring.demo.dao;

import com.spring.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuhaojie on 2023/1/9.
 * @version 1.0
 */
@Mapper
@Repository
public interface StuMapper {
    int insertStu(Student stu);

    Student selectStu(Student stu);

    List<Student> selectStuAll();
}
