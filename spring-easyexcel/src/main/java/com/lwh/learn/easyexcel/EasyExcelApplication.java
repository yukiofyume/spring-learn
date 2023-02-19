package com.lwh.learn.easyexcel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lwh
 * @date 2023-02-18 18:39:07
 * @describe TODO
 */
@MapperScan(basePackages = "com.lwh.learn.easyexcel.repository")
@SpringBootApplication
public class EasyExcelApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplication.class, args);
    }
}
