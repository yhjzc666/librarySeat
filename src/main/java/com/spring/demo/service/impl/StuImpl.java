package com.spring.demo.service.impl;

import com.spring.demo.bean.Student;
import com.spring.demo.dao.StuMapper;
import com.spring.demo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuhaojie on 2023/1/9.
 * @version 1.0
 */
@Service
public class StuImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    @Override
    public int insertStu(Student stu) {
        return stuMapper.insertStu(stu);
    }

    @Override
    public Student selectStu(Student stu) {
        return stuMapper.selectStu(stu);
    }

    @Override
    public List<Student> selectStuAll() {
        return stuMapper.selectStuAll();
    }
}
