package com.dodo.http.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lwh
 * @date 2023-08-13 18:36:10
 * @describe 标记类上，则每个方法都会打印，方法上就只会打印具体方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface WebLog {

    /**
     * @return 入参打印
     */
    boolean requestParams() default true;

    /**
     * @return 出参是否打印
     */
    boolean responseValues() default true;
}
