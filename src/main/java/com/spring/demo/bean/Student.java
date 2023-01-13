package com.spring.demo.bean;

/**
 * @author yuhaojie on 2023/1/6.
 * @version 1.0
 */
import lombok.Data;

import java.io.Serializable;

/**
 * Student
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    private String stuID;

    /**
     * 用户名
     */
    private String username;

    /**
     * 添加时间
     */
    private String time;
    private String banTime;
    private String state;
}