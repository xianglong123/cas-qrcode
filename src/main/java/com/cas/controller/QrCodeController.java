package com.cas.controller;

import cn.hutool.core.io.FileUtil;
import com.cas.service.QRService;
import com.cas.util.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2023/1/30 3:34 下午
 * @desc
 */
@RestController
@RequestMapping("qr/code")
public class QrCodeController {

    @Autowired
    QRService qrService;

    private static final String RootPath = "/Users/xianglong/IdeaProjects/cas-qrcode/src/main/resources/";
    private static final String FileFormat = ".png";

    private static final ThreadLocal<SimpleDateFormat> LOCALDATEFORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMddHHmmss"));


    /**
     * 生成二维码并将其存放于本地目录
     */
    @PostMapping("generate/v1")
    public void generateV1(String content) {
        final String fileName = LOCALDATEFORMAT.get().format(new Date());
        QRCodeUtil.createCodeToFile(content, new File(RootPath), fileName + FileFormat);
    }

    /**
     * 生成二维码并将其返回给前端调用者
     * @param content
     * @param servletResponse
     * @throws IOException
     */
    @PostMapping("generate/v2")
    public void generateV2(String content, HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("image/png");
        QRCodeUtil.createCodeToOutputStream(content, servletResponse.getOutputStream());
    }


    /**
     *
     * @param content
     */
    @PostMapping("hutool/v1")
    public void hutoolV1(String content) {
        final String fileName = LOCALDATEFORMAT.get().format(new Date());
        qrService.generateFile(content, FileUtil.file(RootPath + fileName + FileFormat));
    }

    /**
     *
     * @param content
     * @param servletResponse
     * @throws IOException
     */
    @PostMapping("hutool/v2")
    public void hutoolV2(String content, HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("image/png");
        qrService.generateStream(content,servletResponse);
    }

}
