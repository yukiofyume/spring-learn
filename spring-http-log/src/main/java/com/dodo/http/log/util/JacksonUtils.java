package com.dodo.http.log.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * @author lwh
 * @date 2023-08-13 19:18:03
 * @describe --
 */
@Slf4j
public class JacksonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        //忽略空Bean转json的错误
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> String toJson(T obj) {
        if (Objects.isNull(obj)) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Parse Object to String error", e);
            return null;
        }
    }

    public static <T> T toObject(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || Objects.isNull(clazz)) {
            return null;
        }
        try {
            return objectMapper.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            log.error("Parse String to Object error", e);
            return null;
        }
    }

    public static <T> T toCollection(String str, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(str) || typeReference == null) {
            return null;
        }
        try {
            return objectMapper.readValue(str, typeReference);
        } catch (JsonProcessingException e) {
            log.error("Parse String to Object error", e);
            return null;
        }
    }

    public static <T> T toCollection(String str, Class<?> collectionClazz, Class<?>... elementClazz) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClazz, elementClazz);
        try {
            return objectMapper.readValue(str, javaType);
        } catch (JsonProcessingException e) {
            log.error("Parse String to Object error", e);
            return null;
        }
    }
}
