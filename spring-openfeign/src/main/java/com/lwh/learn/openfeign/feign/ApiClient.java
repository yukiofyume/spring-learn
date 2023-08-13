package com.lwh.learn.openfeign.feign;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lwh
 * @date 2023-08-09 22:36:40
 * @describe --
 */
@FeignClient(url = "https://api.wrdan.com/", name = "apiClient", contextId = "apiClientRemote")
public interface ApiClient {

    @GetMapping("/hitokoto")
    JsonNode getHitokoto();
}
