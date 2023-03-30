package com.spring.demo.dao;

import com.spring.demo.bean.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yuhaojie on 2023/2/15.
 * @version 1.0
 */
@Mapper
@Repository
public interface SeatMapper {
    List<Seat> selectAllSeat();

    List<Seat> selectSomeSeat(Seat seat);

    //Seat selectOneSeat(Seat seat);

    int InsertSeat(Seat seat);

    int updateSate(String seatID);

    List<Seat> getOneSeat(Map inf);

    List<Seat> selectWxSeat(Seat seat);
}
