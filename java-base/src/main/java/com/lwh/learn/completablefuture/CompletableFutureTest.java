package com.lwh.learn.completablefuture;

import com.lwh.learn.config.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lwh
 * @date 2023-02-14 22:29:19
 * @describe TODO
 */
@Slf4j
public class CompletableFutureTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            log.info("执行 step1");
            return "step1 result";
        }, executorService);

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            log.info("执行 step2");
            return "step2 result";
        }, executorService);
        cf1.thenCombine(cf2, (res1, res2) -> {
            log.info(res1 + "," + res2);
            log.info("执行 step3");
            return "step3 result";
        }).thenAccept(log::info);
    }
}
