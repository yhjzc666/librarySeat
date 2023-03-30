package com.spring.demo.service;

import com.spring.demo.bean.Lists;
import com.spring.demo.bean.Seat;

import java.util.List;
import java.util.Map;

/**
 * @author yuhaojie on 2023/2/15.
 * @version 1.0
 */
public interface SeatService {
    List<Seat> selectAllSeat();

    List<Seat> selectSomeSeat(Seat seat);

    //Seat selectOneSeat(Seat seat);

    int InsertSeat(Seat seat);

    int updateSate(String seatID);

    int bookList(Map inf);

    List<Seat> getOneSeat(Map inf);

    List<Seat> selectWxSeat(Seat seat);

    List<Lists> getLists(Map inf);
}
