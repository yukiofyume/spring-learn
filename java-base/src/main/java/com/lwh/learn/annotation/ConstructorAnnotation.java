package com.lwh.learn.annotation;

import java.lang.annotation.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-09 11:49:52
 * @describe --
 */
@Documented
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstructorAnnotation {
    String constructorName() default "";
    String remark() default "构造器";

}
