package com.spring.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuhaojie on 2022/11/7.
 * @version 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class WxUser implements Serializable {
    private String Code;  //只是为了能接收参数，不需要存入数据库
    private String ID; //用户id
    private String OpenID; //微信登录接口返回的参数之一，就是token
    private String UserName;  //微信名
    private String Name; //用户真实姓名
    private String CardID; //用户学号
    private String AvatarUrl;  //头像
    private String StudyState; //预约状态
    private String State;   //帐号状态
    private String StudyTime; //学习次数
    private String DefTime; //违规次数
    private Date FirstLoginTime;  //第一次登录时间
    private Date LastLoginTime;  //最后一次登录时间
}
