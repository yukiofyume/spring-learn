package com.dodo.http.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lwh
 * @date 2023-08-13 18:34:39
 * @describe --
 */
@SpringBootApplication
@EnableFeignClients
public class HttpLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpLogApplication.class, args);
    }
}
