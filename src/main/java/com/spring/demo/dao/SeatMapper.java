package com.spring.demo.dao;

import com.spring.demo.bean.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuhaojie on 2023/2/15.
 * @version 1.0
 */
@Mapper
@Repository
public interface SeatMapper {
    List<Seat> selectAllSeat();

    List<Seat> selectSomeSeat(Seat seat);
}
