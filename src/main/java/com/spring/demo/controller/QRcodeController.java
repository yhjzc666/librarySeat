package com.spring.demo.controller;

import com.spring.demo.service.QRcodeService;
import com.spring.demo.util.QRcodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

/**
 * @Author: 于浩杰
 * @Date: 2023/4/19 10:30
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Controller
public class QRcodeController {
    @Autowired
    private QRcodeService qRcodeService;

    @ResponseBody
    @RequestMapping(value = "/HaveQRcode")
    public void HaveQRcode() {
        try {
            QRcodeUtil qRcodeUtil = new QRcodeUtil();
            String filePath = "D:\\QRcode\\CRGscan.png";
            String filePaths = "D:\\QRcode\\";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = sdf.format(System.currentTimeMillis());
            int delNum = qRcodeService.deleteQRcode();
            int num = qRcodeService.insertQRcode(qRcodeUtil.getUUID(), filePath, time);
            //Xiaojie wants to eat eggs就是我们的生成规则，可随便填写
            qRcodeUtil.getQRCodeImage("/pages/sweep/sweep", 350, 350, filePaths);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
