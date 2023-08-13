package com.lwh.learn.openfeign;

import com.fasterxml.jackson.databind.JsonNode;
import com.lwh.learn.openfeign.feign.ApiClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lwh
 * @date 2023-08-09 22:42:45
 * @describe --
 */
@Slf4j
@SpringBootTest
class OpenFeignApplicationTest {

    @Autowired
    private ApiClient apiClient;

    @Test
    void getHitokotoTest() {
        JsonNode hitokoto = apiClient.getHitokoto();
        log.info("hitokoto:{}", hitokoto);
    }
}