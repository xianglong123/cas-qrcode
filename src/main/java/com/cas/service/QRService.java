package com.cas.service;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Service
public class QRService {
    @Resource
    QrConfig qrconig;

    public void generateFile(String content, File file) {
        //生成到本地文件
        QrCodeUtil.generate(content, qrconig, file);
    }

    //输出到流
    public void generateStream(String content, HttpServletResponse response) throws IOException {
        QrCodeUtil.generate(content, qrconig, "png", response.getOutputStream());
    }
}