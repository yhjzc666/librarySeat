package com.spring.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.demo.bean.Lists;
import com.spring.demo.bean.Seat;
import com.spring.demo.service.SeatService;
import com.spring.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.demo.util.SystemAttributeUtil;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
            } else if ("3".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"
                seats.setGrandPID("自习室");
            }
            if ("4".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            } else if ("5".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            } else if ("6".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("四楼");
            } else if ("7".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("五楼");
            } else if ("8".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("一楼");
            } else if ("9".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            } else if ("10".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            }
            if ("1".equals(seats.getState())) {
                seats.setState("空闲");
            } else if ("2".equals(seats.getState())) {
                seats.setState("不可选");
            } else if ("3".equals(seats.getState())) {
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
            } else if ("3".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"
                seats.setGrandPID("自习室");
            }
            if ("4".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            } else if ("5".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            } else if ("6".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("四楼");
            } else if ("7".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("五楼");
            } else if ("8".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("一楼");
            } else if ("9".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            } else if ("10".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            }
            if ("1".equals(seats.getState())) {
                seats.setState("空闲");
            } else if ("2".equals(seats.getState())) {
                seats.setState("不可选");
            } else if ("3".equals(seats.getState())) {
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

    @ResponseBody
    @RequestMapping(value = "/selectWxSeat")
    public Map selectWxSeat(@RequestBody Seat seat) {
        List<Seat> result = seatService.selectWxSeat(seat);
        // 循环遍历List集合
        for (Seat seats : result) {
            // 判断state属性值是否为"unoccupied"
            if ("2".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"
                seats.setGrandPID("图书馆");
            } else if ("3".equals(seats.getGrandPID())) {
                // 修改state属性值为"available"
                seats.setGrandPID("自习室");
            }
            if ("4".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            } else if ("5".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            } else if ("6".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("四楼");
            } else if ("7".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("五楼");
            } else if ("8".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("一楼");
            } else if ("9".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("二楼");
            } else if ("10".equals(seats.getParentID())) {
                // 修改state属性值为"available"
                seats.setParentID("三楼");
            }
            if ("1".equals(seats.getState())) {
                seats.setState("空闲");
            } else if ("2".equals(seats.getState())) {
                seats.setState("不可选");
            } else if ("3".equals(seats.getState())) {
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


    @ResponseBody
    @RequestMapping(value = "/insertSeat")
    public Map InsertSeat(@RequestBody Seat seats) {
        System.out.println(seats);
        if ("图书馆".equals(seats.getGrandPID())) {
            // 修改state属性值为"available"
            seats.setGrandPID("2");
        } else if ("自习室".equals(seats.getGrandPID())) {
            // 修改state属性值为"available"
            seats.setGrandPID("3");
        }
        if ("二楼".equals(seats.getParentID())) {
            // 修改state属性值为"available"
            seats.setParentID("4");
        } else if ("三楼".equals(seats.getParentID())) {
            // 修改state属性值为"available"
            seats.setParentID("5");
        } else if ("四楼".equals(seats.getParentID())) {
            // 修改state属性值为"available"
            seats.setParentID("6");
        } else if ("五楼".equals(seats.getParentID())) {
            // 修改state属性值为"available"
            seats.setParentID("7");
        } else if ("一楼".equals(seats.getParentID())) {
            // 修改state属性值为"available"
            seats.setParentID("8");
        } else if ("二楼".equals(seats.getParentID())) {
            // 修改state属性值为"available"
            seats.setParentID("9");
        } else if ("三楼".equals(seats.getParentID())) {
            // 修改state属性值为"available"
            seats.setParentID("10");
        }
        if ("空闲".equals(seats.getState())) {
            seats.setState("1");
        } else if ("不可选".equals(seats.getState())) {
            seats.setState("2");
        } else if ("已选".equals(seats.getState())) {
            seats.setState("3");
        }
        JSONObject object = new JSONObject();
        List<Seat> result = seatService.selectSomeSeat(seats);
        System.out.println(result);
        if (result.size() != 0) {
            object.put("code", 300);
            object.put("msg", "添加失败!");
            return object;
        }
        seats.setTime(String.valueOf(System.currentTimeMillis()));
        seats.setSeatID(SystemAttributeUtil.getUUID());
        System.out.println(seats);
        int num = seatService.InsertSeat(seats);
        if (num == 1) {
            object.put("code", 200);
            object.put("msg", "添加成功!");
            object.put("userInfo", seats);
        } else {
            object.put("code", 400);
            object.put("msg", "添加失败!");
        }
        return object;
    }

    @ResponseBody
    @RequestMapping(value = "/bookSeat")
    public Map BookSeat(@RequestBody Map Inf) {
        /*
         *判断是否是在可预约时间内
         * */
        JSONObject object = new JSONObject();
        String strStartTime1 = "6:00";
        String strEndTime1 = "21:00";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String now = sdf.format(new Date());
        Date nowTime;
        /*
         * 判断数据库内是否有当日预约信息(未结束的)
         * */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        String currentDateString = dateFormat.format(currentDate);
        try {
            nowTime = sdf.parse(now);
            Date startTime1 = sdf.parse(strStartTime1);
            Date endTime1 = sdf.parse(strEndTime1);
            // 注：也可以通过此方式判断当前时间是否具体时间段内 yyyy-MM-dd HH:mm:ss格式 [2022-03-09 12:00:00,2022-03-10 15:00:00]
            //   当前时间和时间段的格式保持一致即可判断
            if (isEffectiveDate(nowTime, startTime1, endTime1)) {
                List<Lists> lists = seatService.getLists(Inf);
                for (Lists listR : lists) {
                    /*
                     * 判断预约信息是否已经结束
                     * */
                    if (listR.getFinishTime() == null) {
                        /*
                         *判断是否是在同一天
                         * */
                        if (currentDateString.substring(0, 10).equals(listR.getStartTime().substring(0, 10))) {
                            object.put("code", 700);
                            object.put("msg", "不可重复预约");
                            return object;
                        } else {
                            /*
                             * 判断预约座位是否已经被预约了
                             * */
                            List<Seat> num = seatService.getOneSeat(Inf);
                            if (num.size() == 0) {
                                object.put("code", 500);
                                return object;
                            }
                            String seatID = (String) Inf.get("Inf");
                            String startTime = currentDateString;
                            Inf.put("startTime", startTime);
                            Inf.put("ID", SystemAttributeUtil.getUUID());
                            int updateResult = seatService.updateSate(seatID);
                            int inserResult = seatService.bookList(Inf);
                            if (updateResult == 1 && inserResult == 1) {
                                object.put("code", 200);
                                object.put("userInfo", selectAllSeat());
                            } else {
                                object.put("code", 400);
                            }
                            return object;
                        }
                    }
                }
            } else {
                object.put("code", 600);
                object.put("msg", "未在预约时间内");
                return object;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意三个参数的时间格式要一致
     *
     * @param nowTime
     * @param startTime
     * @param endTime
     * @return 在时间段内返回true，不在返回false
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        return date.after(begin) && date.before(end);
    }
}
