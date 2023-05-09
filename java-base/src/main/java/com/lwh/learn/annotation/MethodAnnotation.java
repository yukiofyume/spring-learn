package com.lwh.learn.annotation;

import java.lang.annotation.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-09 11:53:22
 * @describe --
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
    String name() default "defaultName";

    MethodTypeEnum type() default MethodTypeEnum.TYPE1;
}
