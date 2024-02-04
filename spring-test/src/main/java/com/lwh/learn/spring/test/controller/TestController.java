package com.lwh.learn.spring.test.controller;

import com.lwh.learn.config.ThreadPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lwh
 * @date 2024-02-04 23:12:56
 * @describe -
 */
@RestController
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/completable-future-task-test")
    public void completableFutureTaskTest() {
        CompletableFuture<Long> longCompletableFuture = task1();
        CompletableFuture<String> stringCompletableFuture = task2();
        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.allOf(longCompletableFuture, stringCompletableFuture);
        AtomicReference<String> s = new AtomicReference<>("");
        voidCompletableFuture.thenRun(() -> {
            Long value = longCompletableFuture.join();
            String str = stringCompletableFuture.join();
            s.set(value + str);
        }).join();
        LOGGER.info("[completableFutureTaskTest:{}]", s);
    }

    private CompletableFuture<Long> task1() {
        return CompletableFuture.supplyAsync(() -> {
            LOGGER.info("[task1]");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LOGGER.info("[task1 开始执行!]");
            return 10L;
        }, ThreadPoolConfig.getTreadPoolExecutor());
    }

    private CompletableFuture<String> task2() {
        return CompletableFuture.supplyAsync(() -> {

            LOGGER.info("[task2 开始执行!]");
            return "SUCCESS";
        }, ThreadPoolConfig.getTreadPoolExecutor());
    }
}
