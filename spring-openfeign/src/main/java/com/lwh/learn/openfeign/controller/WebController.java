package com.lwh.learn.openfeign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwh
 * @date 2023-12-13 20:17:30
 * @describe --
 */
@RestController
public class WebController {

    @GetMapping("/getString.do")
    public String getString(@RequestParam("content") String content) {
        return "getString! " + content;
    }
}
