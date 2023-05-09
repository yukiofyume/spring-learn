package com.lwh.learn.annotation;

import java.lang.annotation.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-09 11:51:21
 * @describe --
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
    String name() default "defaultName";

    String value() default "defaultValue";
}
