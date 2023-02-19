package com.lwh.learn.completablefuture;

import com.lwh.learn.config.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author lwh
 * @date 2023-02-14 22:29:19
 * @describe TODO
 */
@Slf4j
public class CompletableFutureTest {

    public static void main(String[] args) {
        try {
            CompletableFuture.runAsync(() -> log.info("开始执行"), ThreadPoolConfig.getThreadPoolExecutor()).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        var ff = 0;
    }
}
