package com.spring.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.bean.Seat;
import com.spring.demo.bean.Student;
import com.spring.demo.service.SeatService;
import com.spring.demo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author yuhaojie on 2022/12/30.
 * @version 1.0
 */
@Controller
public class SeatsController {
    @Autowired
    private SeatService seatService;

    @ResponseBody
    @RequestMapping(value = "/selectAllSeat")
    public Map selectAllSeat() {
        List<Seat> result = seatService.selectAllSeat();
        for (Seat seats : result) {
            // 判断state属性值是否为"unoccupied"
            if ("2".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"
                seats.setGrandPID("图书馆");
            }
            else if ("3".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"
                seats.setGrandPID("自习室");
            }
            if ("4".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            }
            else if ("5".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            }
            else if ("6".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("四楼");
            }
            else if ("7".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("五楼");
            }
            else if ("8".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("一楼");
            } else if ("9".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            } else if ("10".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            }
            if("1".equals(seats.getState())){
                seats.setState("空闲");
            }else if("2".equals(seats.getState())){
                seats.setState("不可选");
            }else if("3".equals(seats.getState())){
                seats.setState("已选");
            }
        }
        JSONObject object = new JSONObject();
        object.put("code", 200);
        object.put("msg", "查询成功!");
        object.put("seatDate", result);
        return object;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSomeSeat")
    public Map selectSomeSeat(@RequestBody Seat seat) {
        List<Seat> result = seatService.selectSomeSeat(seat);
        // 循环遍历List集合
        for (Seat seats : result) {
            // 判断state属性值是否为"unoccupied"
            if ("2".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"
                seats.setGrandPID("图书馆");
            }
            else if ("3".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"
                seats.setGrandPID("自习室");
            }
            if ("4".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            }
            else if ("5".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            }
            else if ("6".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("四楼");
            }
            else if ("7".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("五楼");
            }
            else if ("8".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("一楼");
            } else if ("9".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            } else if ("10".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            }if("1".equals(seats.getState())){
                seats.setState("空闲");
            }else if("2".equals(seats.getState())){
                seats.setState("不可选");
            }else if("3".equals(seats.getState())){
                seats.setState("已选");
            }
        }
       // System.out.println(result);
        JSONObject object = new JSONObject();
        object.put("code", 200);
        object.put("msg", "查询成功!");
        object.put("seatDate", result);
        return object;
    }


}
