package com.spring.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.bean.Lists;
import com.spring.demo.service.ListsService;
import com.spring.demo.service.SeatService;
import com.spring.demo.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yuhaojie on 2023/3/29.
 * @version 1.0
 */
@Controller
public class ListsController {
    @Autowired
    private ListsService listsService;

    @Autowired
    private WxUserService wxUserService;

    @Autowired
    private SeatService seatService;

    @ResponseBody
    @RequestMapping(value = "/listsSelect")
    public Object listsSelect(@RequestBody Lists lists) {
        List<Lists> listsResult = listsService.listsSelect(lists);
        for (Lists listAyy : listsResult) {
            // 判断state属性值是否为"unoccupied"
            if ("2".equals(listAyy.getGrandPID())) {
                // 修改state属性值为"available"
                listAyy.setGrandPID("图书馆");
            } else if ("3".equals(listAyy.getGrandPID())) {
                // 修改state属性值为"available"
                listAyy.setGrandPID("自习室");
            }
            if ("4".equals(listAyy.getParentID())) {
                // 修改state属性值为"available"
                listAyy.setParentID("二楼");
            } else if ("5".equals(listAyy.getParentID())) {
                // 修改state属性值为"available"
                listAyy.setParentID("三楼");
            } else if ("6".equals(listAyy.getParentID())) {
                // 修改state属性值为"available"
                listAyy.setParentID("四楼");
            } else if ("7".equals(listAyy.getParentID())) {
                // 修改state属性值为"available"
                listAyy.setParentID("五楼");
            } else if ("8".equals(listAyy.getParentID())) {
                // 修改state属性值为"available"
                listAyy.setParentID("一楼");
            } else if ("9".equals(listAyy.getParentID())) {
                // 修改state属性值为"available"
                listAyy.setParentID("二楼");
            } else if ("10".equals(listAyy.getParentID())) {
                // 修改state属性值为"available"
                listAyy.setParentID("三楼");
            }
        }
        JSONObject object = new JSONObject();
        object.put("code", 200);
        object.put("msg", "查询成功!");
        object.put("seatDate", listsResult);
        return object;
    }

    @ResponseBody
    @RequestMapping(value = "/bookListALl")
    public Object bookListALl() {
        List<Lists> listsResult = listsService.listsALlSelect();
        for (Lists seats : listsResult) {
            // 判断state属性值是否为"unoccupied"
            if ("2".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"seats.setGrandPID("图书馆");
            } else if ("3".equals(seats.getGrandPID())) {
                seats.setGrandPID("自习室");
            }
            if ("4".equals(seats.getParentID())) {
                seats.setParentID("二楼");
            } else if ("5".equals(seats.getParentID())) {
                seats.setParentID("三楼");
            } else if ("6".equals(seats.getParentID())) {
                seats.setParentID("四楼");
            } else if ("7".equals(seats.getParentID())) {
                seats.setParentID("五楼");
            } else if ("8".equals(seats.getParentID())) {
                seats.setParentID("一楼");
            } else if ("9".equals(seats.getParentID())) {
                seats.setParentID("二楼");
            } else if ("10".equals(seats.getParentID())) {
                seats.setParentID("三楼");
            }
            if ("0".equals(seats.getState())) {
                seats.setState("已预约");
            } else if ("1".equals(seats.getState())) {
                seats.setState("使用中");
            } else if ("2".equals(seats.getState())) {
                seats.setState("已结束");
            }
        }
        JSONObject object = new JSONObject();
        object.put("code", 200);
        object.put("msg", "查询成功!");
        object.put("seatDate", listsResult);
        return object;
    }

    @ResponseBody
    @RequestMapping(value = "/updateSweepList")
    public Object updateSweepList(@RequestBody Lists lists) {
        List<Lists> listsResult = listsService.listsSelectBookIng(lists);
        JSONObject object = new JSONObject();
        object.put("code", 200);
        object.put("msg", "查询成功!");
        object.put("seatDate", listsResult);
        return object;
    }

    @ResponseBody
    @RequestMapping(value = "/updateListStates")
    public Object updateListStates(@RequestBody Lists lists) {
        JSONObject object = new JSONObject();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDates = new Date();
        String currentDateString = dateFormat.format(currentDates);
        List<Lists> selectList = listsService.selectListStates(lists);
        if (selectList.size() == 0) {
            object.put("code", 300);//啥也不需要修改
        } else if (selectList.size() == 1) {
            for (Lists res : selectList
            ) {
                if ("1".equals(res.getState())) {
                    System.out.println("目前是使用中");
                    if ("1".equals(lists.getState())) {//入馆，违规
                        System.out.println("违规了");
                    } else if ("2".equals(lists.getState())) { //出馆，直接结束
                        lists.setID(res.getID());
                        lists.setFinishTime(currentDateString);
                        lists.setSeatID(res.getSeatID());
                        int listsResult = listsService.updateListStates(lists);
                        int numSeat = seatService.updateSeatState(res.getSeatID(), "1");
                        if (listsResult == 1 && numSeat == 1) {
                            object.put("code", 200);
                            object.put("msg", "结束成功!");
                        }
                        //填写使用中的修改状态 需要修改订单和座位状态
                    }
                } else if ("0".equals(res.getState())) {
                    System.out.println("目前是已预约");
                    if ("1".equals(lists.getState())) {//入馆
                        lists.setID(res.getID());
                        lists.setFinishTime(null);
                        int listsResult = listsService.updateListStates(lists);
                        if (listsResult == 1) {
                            object.put("code", 200);
                            object.put("msg", "使用成功!");
                        }
                        //填写已预约的修改状态 只需要修改订单状态
                    } else if ("2".equals(lists.getState()) || "4".equals(lists.getState())) {//出馆，直接结束
                        lists.setID(res.getID());
                        lists.setFinishTime(currentDateString);
                        lists.setState("2");
                        lists.setSeatID(res.getSeatID());
                        int listsResult = listsService.updateListStates(lists);
                        int numSeat = seatService.updateSeatState(res.getSeatID(), "1");
                        if (listsResult == 1 && numSeat == 1) {
                            object.put("code", 200);
                            object.put("msg", "结束成功!");
                        }

                    }


                } else if ("2".equals(res.getState())) {
                    System.out.println("目前是已结束");
                    //int listsResult = listsService.updateListStates(lists);
                    //填写已结束的修改状态
                }
            }
        } else {
            object.put("code", 400);//可能重复预约
        }

        //object.put("seatDate", listsResult);
        return object;
    }
}
