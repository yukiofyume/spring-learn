package com.lwh.learn.security.controller;

import com.lwh.learn.security.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwh
 * @date 2023-11-07 23:53:28
 * @describe --
 */
@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public void hello() {
        helloService.hello();
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "user";
    }

    @GetMapping("/remember-me")
    public String rememberMe() {
        return "rememberMe";
    }

}
