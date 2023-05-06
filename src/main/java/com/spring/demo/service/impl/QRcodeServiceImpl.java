package com.spring.demo.service.impl;

import com.spring.demo.dao.QRcodeMapper;
import com.spring.demo.service.QRcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 于浩杰
 * @Date: 2023/4/19 19:36
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Service
public class QRcodeServiceImpl implements QRcodeService {
    @Autowired
    private QRcodeMapper qRcodeMapper;

    @Override
    public int insertQRcode(String id, String filePath, String time) {

        return qRcodeMapper.insertQRcode(id, filePath, time);
    }

    @Override
    public int deleteQRcode() {
        return qRcodeMapper.deleteQRcode();
    }
}
