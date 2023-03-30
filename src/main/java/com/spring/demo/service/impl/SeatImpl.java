package com.spring.demo.service.impl;

import com.spring.demo.bean.Lists;
import com.spring.demo.bean.Seat;
import com.spring.demo.dao.ListMapper;
import com.spring.demo.dao.SeatMapper;
import com.spring.demo.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yuhaojie on 2023/2/15.
 * @version 1.0
 */
@Service
public class SeatImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private ListMapper listMapper;
    @Override
    public List<Seat> selectAllSeat() {
        return seatMapper.selectAllSeat();
    }

    @Override
    public List<Seat> selectSomeSeat(Seat seat) {
        return seatMapper.selectSomeSeat(seat);
    }

//    @Override
//    public Seat selectOneSeat(Seat seat) {
//        return seatMapper.selectOneSeat(seat);
//    }

    @Override
    public int InsertSeat(Seat seat) {
        return seatMapper.InsertSeat(seat);
    }

    @Override
    public int updateSate(String seatID) {
        return seatMapper.updateSate(seatID);
    }

    @Override
    public int bookList(Map inf) {
        return listMapper.bookList(inf);
    }

    @Override
    public List<Seat> getOneSeat(Map inf) {
        return seatMapper.getOneSeat(inf);
    }

    @Override
    public List<Seat> selectWxSeat(Seat seat) {
        return seatMapper.selectWxSeat(seat);
    }

    @Override
    public List<Lists> getLists(Map inf) {
        return listMapper.getLists(inf);
    }
}
