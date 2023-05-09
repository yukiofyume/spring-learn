package com.lwh.learn.annotation;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-09 14:05:17
 * @describe --
 */
@Slf4j
public class TestClassAnnotation {
    private static Person person = new Person();

    public static void main(String[] args) {
        Class<? extends Person> clazz = person.getClass();
        if (clazz.isAnnotationPresent(ClassAnnotation.class)) {
           log.info("This is a class with annotation ClassAnnotation");
            ClassAnnotation annotation = clazz.getAnnotation(ClassAnnotation.class);
            if (!Objects.isNull(annotation)) {
                log.info("beanName:{}", annotation.name());
                log.info("version:{}", annotation.version());
            }
        }
    }
}
