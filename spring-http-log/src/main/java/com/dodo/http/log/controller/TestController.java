package com.dodo.http.log.controller;

import com.dodo.http.log.annotation.WebLog;
import com.dodo.http.log.feign.ApiClient;
import com.dodo.http.log.util.JacksonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwh
 * @date 2023-08-13 19:43:01
 * @describe --
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ApiClient apiClient;

    @WebLog
    @PostMapping("/test1")
    public String test1() {
        JsonNode hitokoto = apiClient.getHitokoto();
        return JacksonUtils.toJson(hitokoto);
    }
}
