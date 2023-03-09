package com.spring.demo.service.impl;

import com.spring.demo.bean.Seat;
import com.spring.demo.dao.SeatMapper;
import com.spring.demo.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuhaojie on 2023/2/15.
 * @version 1.0
 */
@Service
public class SeatImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;
    @Override
    public List<Seat> selectAllSeat() {
        return seatMapper.selectAllSeat();
    }

    @Override
    public List<Seat> selectSomeSeat(Seat seat) {
        return seatMapper.selectSomeSeat(seat);
    }
}
