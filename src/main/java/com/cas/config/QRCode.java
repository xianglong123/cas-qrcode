package com.cas.config;

import cn.hutool.extra.qrcode.QrConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
public class QRCode {

    @Bean
    public QrConfig qrConfig() {
        QrConfig config = new QrConfig(500, 500);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.pink);
        // 设置背景色（灰色）
        config.setBackColor(Color.white);
        return config;
    }
}