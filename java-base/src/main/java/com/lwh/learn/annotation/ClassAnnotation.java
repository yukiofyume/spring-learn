package com.lwh.learn.annotation;

import java.lang.annotation.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-09 11:20:06
 * @describe --
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassAnnotation {
    String name() default "defaultService";

    String version() default "1.0";
}
