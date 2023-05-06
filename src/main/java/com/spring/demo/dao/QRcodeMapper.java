package com.spring.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: 于浩杰
 * @Date: 2023/4/19 19:39
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
@Repository
public interface QRcodeMapper {
    int insertQRcode(String id, String filePath, String time);

    int deleteQRcode();
}
