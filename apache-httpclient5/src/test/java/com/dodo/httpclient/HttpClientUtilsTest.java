package com.dodo.httpclient;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwh
 * @date 2023-12-13 20:30:02
 * @describe --
 */

class HttpClientUtilsTest {

    private final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtilsTest.class);

    @Test
    void getStringTest() {
        Map<String, Object> params = new HashMap<>();
        params.put("content", "这是测试");
        String s = HttpClientUtils.get("http://127.0.0.1:8001/openfeign/getString.do", params);
        LOGGER.info(s);
    }

}