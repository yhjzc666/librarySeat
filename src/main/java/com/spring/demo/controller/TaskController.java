package com.spring.demo.controller;

import com.spring.demo.bean.Lists;
import com.spring.demo.bean.WxUser;
import com.spring.demo.service.ListsService;
import com.spring.demo.service.SeatService;
import com.spring.demo.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Author: 于浩杰
 * @Date: 2023/3/31 17:02
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Component
public class TaskController {

    @Autowired
    private ListsService listsService;

    @Autowired
    private SeatService seatService;
    @Autowired
    private WxUserService wxUserService;

    @Scheduled(fixedRate = 1000)
    public void executeTask() {
        // 在这里编写需要执行的方法逻辑
        LocalDateTime now = LocalDateTime.now();
        LocalDate currentDate = now.toLocalDate(); // 获取当前日期
        LocalTime currentTime = now.toLocalTime(); // 获取当前时间

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        /*获取当前时间
         * */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDates = new Date();
        String currentDateString = dateFormat.format(currentDates);

        List<Lists> listsResult = listsService.listsALlSelect();
        for (Lists lists : listsResult
        ) {
            if ("".equals(lists.getFinishTime()) || null == lists.getFinishTime()) {
                String dbTimeStr = lists.getStartTime();
                LocalDateTime dbTime = LocalDateTime.parse(dbTimeStr, formatter);
                if (currentDate.equals(dbTime.toLocalDate())) { // 如果日期相同
                    LocalTime queryTime = LocalTime.of(22, 0); // 查询时间为当天的10点
                    if (currentTime.isBefore(queryTime)) { // 如果当前时间早于查询时间
                    } else {
                        updateLists(lists.getID(), lists.getSeatID(), currentDateString);//是当天已经超过10点
                    }
                    /*
                     * 正常系统一直开放，不需要判断时间有没有超过今天
                     * 但考虑没有投入使用，可能会关机，所以先保留超过当天的可能
                     * */
                } else {
                    updateLists(lists.getID(), lists.getSeatID(), currentDateString);//当前时间不是数据库查询时间当天
                }
            }
        }
        //System.out.println(listsResult);


    }

    public void updateLists(String listId, String seatId, String times) {
        String listState = "2";
        int numList = listsService.updateLists(listId, times, listState);
        if (numList != 0) {
            WxUser wxUser = new WxUser();
            String openID = wxUser.getOpenID();
            int num = wxUserService.insertSyudyTime(openID, numList);
        }
        String state = "1";
        int numSeat = seatService.updateSeatState(seatId, state);
    }
}
