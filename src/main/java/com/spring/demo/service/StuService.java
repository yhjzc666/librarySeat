package com.spring.demo.service;

import com.spring.demo.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuhaojie on 2023/1/9.
 * @version 1.0
 */
public interface StuService {
    int insertStu(Student stu);

    Student selectStu(Student stu);

    List<Student> selectStuAll();

    int deleteStu(ArrayList<Object> list);

    List<Student> selectOneStu(String stuID);

    int updateStu(Student stu);
}
