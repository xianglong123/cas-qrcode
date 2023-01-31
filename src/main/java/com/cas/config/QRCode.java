package com.cas.config;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
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
        // 设置纠错级别 L、M、Q、H几个参数，由低到高
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        //  设置中间图
        config.setImg(new ClassPathResource("logo/" + "logo.png").getPath());
        return config;
    }
}