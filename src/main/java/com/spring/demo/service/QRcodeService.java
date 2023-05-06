package com.spring.demo.service;

/**
 * @Author: 于浩杰
 * @Date: 2023/4/19 10:37
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface QRcodeService {

    int insertQRcode(String uuid, String filePath, String time);

    int deleteQRcode();
}
