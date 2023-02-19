package com.lwh.learn.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author lwh
 * @date 2023-02-18 22:40:57
 * @describe TODO
 */
@Slf4j
public class JacksonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

//    static {
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//    }

    /**
     * entity => json
     *
     * @param entity entity
     * @return String
     */
    public static String entity2Json(Object entity) {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            log.error("serialization fail", e);
            throw new RuntimeException("serialization fail", e);
        }
    }

    public static <T> T json2Entity(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            log.error("deSerialization fail(String ,Class<T)", e);
            throw new RuntimeException("deSerialization fail", e);
        }
    }

    public static <T> T byte2Entity(byte[] bytes, Class<T> valueType) {
        try {
            return objectMapper.readValue(bytes, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObjectNode objectNode() {
        return objectMapper.createObjectNode();
    }
}

