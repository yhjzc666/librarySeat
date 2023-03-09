package com.spring.demo.service;

import com.spring.demo.bean.Seat;

import java.util.List;

/**
 * @author yuhaojie on 2023/2/15.
 * @version 1.0
 */
public interface SeatService {
    List<Seat> selectAllSeat();

    List<Seat> selectSomeSeat(Seat seat);
}
