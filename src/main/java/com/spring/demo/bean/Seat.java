package com.spring.demo.bean;

/**
 * @author yuhaojie on 2023/2/15.
 * @version 1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * Student
 */
@Data
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    private String seatID;

    /**
     * 用户名
     */
    private String parentID;

    /**
     * 添加时间
     */
    private String time;
    private String grandPID;
    private String state;
    private String number;
}