package com.spring.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.bean.Bull;
import com.spring.demo.service.BullService;
import com.spring.demo.util.SystemAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author: 于浩杰
 * @Date: 2023/4/9 15:45
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Controller
public class BullController {
    @Autowired
    private BullService bullService;

    @ResponseBody
    @RequestMapping(value = "/bullSelect")
    public Object bullSelect() {
        JSONObject objectObjectMap = new JSONObject();
        List<Bull> result = bullService.bullSelect();
        for (Bull re : result
        ) {
            if ("1".equals(re.getState())) {
                re.setState("已发布");
            } else if ("2".equals(re.getState())) {
                re.setState("已撤销");
            } else if ("3".equals(re.getState())) {
                re.setState("已保存");
            }
        }
        objectObjectMap.put("code", "200");
        objectObjectMap.put("date", result);
        objectObjectMap.put("msg", "返回成功");
        return objectObjectMap;
    }

    @ResponseBody
    @RequestMapping(value = "/insertBulls")
    public Object insertBulls(@RequestBody Bull bull) {
        JSONObject objectObjectMap = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(System.currentTimeMillis());
        String ID = SystemAttributeUtil.getUUID();
        bull.setID(ID);
        bull.setTime(time);
        int result = bullService.insertBulls(bull);
        objectObjectMap.put("code", "200");
        objectObjectMap.put("date", result);
        objectObjectMap.put("msg", "返回成功");
        return objectObjectMap;
    }
}
