package com.lwh.learn.completablefuture;

import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * @author lwh
 * @date 2023-07-27 00:17:46
 * @describe --
 */
public class ExceptionUtils {


    /**
     * 提取真正的异常
     */
    public static Throwable extractRealException(Throwable throwable) {
        if (throwable instanceof CompletionException || throwable instanceof ExecutionException) {
            if (throwable.getCause() != null) {
                return throwable.getCause();
            }
        }
        return throwable;
    }
}
