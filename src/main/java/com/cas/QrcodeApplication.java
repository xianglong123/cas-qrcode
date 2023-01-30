package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 上午10:26 2022/11/25
 * @version: V1.0
 * @review: 主要模拟EXCEL的导出，压缩，遍历
 */
@SpringBootApplication(scanBasePackages = "com.cas")
public class QrcodeApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(QrcodeApplication.class, args);
            System.out.println("启动成功！！！！");
        } catch (Exception e) {
            System.out.println("启动失败！！！！");
        }
    }

}
