package com.spring.demo.bean;

import lombok.Data;

/**
 * @Author: 于浩杰
 * @Date: 2023/5/2 9:47
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Data
public class Question {
    private String ID;
    private String question;
    private String reply;
    private String state;
    private String openID;
    private String subTime;
    private String repTime;
    private String stuID;
    private String username;

}
