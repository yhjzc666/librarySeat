package com.spring.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.bean.User;
import com.spring.demo.bean.WxUser;
import com.spring.demo.service.SysUserService;
import com.spring.demo.service.WxUserService;
import com.spring.demo.util.JwtUtil;
import com.spring.demo.util.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yuhaojie on 2022/7/15.
 * @version 1.0
 */
@Controller
public class LoginController {
    /*
     * 微信小程序  ↓
     *           ↓
     *           ↓
     * */
    String AppId = "wx27737a0b47366b55";  //公众平台自己的appId
    String AppSecret = "e272d7ebbd50cb3f5183d161fe80d682";  //AppSecre
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private WxUserService wxUserService;

    /*
     * 管理端
     * */
    @ResponseBody
    @RequestMapping(value = "/login")
    public Map login(@RequestBody User user) {
        //生成token用
        Map<String, Object> info = new HashMap<>();
        info.put("username", user.getUsername());
        info.put("pass", user.getPassword());
        String userId = UUID.randomUUID().toString();
        String token = JwtUtil.sign(userId, info);
        User result = sysUserService.login(user.getUsername());
        Map<Object, String> map = new HashMap<>();
        if (result == null) {
            map.put("code", "300");  //不存在用户
        } else if (result.getPassword().equals(user.getPassword())) {
            map.put("code", "200");  //密码正确
            map.put("token", token);
        } else {
            map.put("code", "400"); //密码错误
        }
        //返回结果用


        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/Xcxlogin")
    public Map Xcxlogin(@RequestBody WxUser user) {
        JSONObject object = new JSONObject();
        if (user.getCode() == "" || "".equals(user.getCode())) {
            object.put("code", 300);
            object.put("msg", "code不能为空!");
            return object;
        } else {
            //微信接口服务,通过调用微信接口服务中jscode2session接口获取到openid和session_key
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + AppId + "&secret=" + AppSecret + "&js_code=" + user.getCode() + "&grant_type=authorization_code";
            String str = WeChatUtil.httpRequest(url, "GET", null); //调用工具类解密
            JSONObject jsonObject = JSONObject.parseObject(str);
            String openid = (String) jsonObject.get("openid");
            if (openid != null && !"".equals(openid)) {
                //登录成功
                WxUser userVo = new WxUser();
                userVo.setUserName(user.getUserName());
                userVo.setAvatarUrl(user.getAvatarUrl());
                userVo.setOpenID(openid);
                userVo.setStudyState("0");//0 未预约 1已预约 2正在使用userVo.setDefTime("0");
                userVo.setStudyTime("0");
                userVo.setDefTime("0");
                userVo.setState("0"); //0 正常；1封号userVo.setID(SystemAttributeUtil.getUUID());
                userVo.setFirstLoginTime(new Date(System.currentTimeMillis()));
                userVo.setLastLoginTime(new Date(System.currentTimeMillis()));
                WxUser us = wxUserService.queryByOpenId(openid);
                if (us != null) {
                    //不是首次登录，更新用户信息
                    userVo.setOpenID(us.getOpenID());
                    userVo.setName(us.getName());
                    userVo.setStuID(us.getStuID());
                    userVo.setCardID(us.getCardID());
                    wxUserService.updateUser(userVo);
                } else {
                    //首次登录，存储用户信息
                    wxUserService.insertUser(userVo);
                }
                object.put("code", 200);
                object.put("msg", "登录成功!");
                object.put("userInfo", userVo);
                return object;
            } else {
                object.put("code", 400);
                object.put("msg", "未知错误，请重试!");
                return object;
            }
        }

    }

    @ResponseBody
    @RequestMapping(value = "/XcxUpdataUserInform")
    public Map XcxUpdataUserInform(@RequestBody WxUser wxUser) {
        int result = wxUserService.updateUser(wxUser);
        JSONObject object = new JSONObject();
        if (result == 1) {
            WxUser us = wxUserService.queryByOpenId(wxUser.getOpenID());
            object.put("code", 200);
            object.put("msg", "修改成功!");
            object.put("userInfo", us);
            return object;
        } else {
            object.put("code", 400);
            object.put("msg", "修改失败!");
            return object;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/XcxGetUserInform")
    public Map XcxGetUserInform(@RequestBody String openID) {
        JSONObject object = new JSONObject();
        WxUser us = wxUserService.queryByOpenId(openID);
        object.put("code", 200);
        object.put("msg", "查找成功!");
        object.put("userInfo", us);
        return object;
    }
}
