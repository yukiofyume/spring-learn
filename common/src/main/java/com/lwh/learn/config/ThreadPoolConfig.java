package com.lwh.learn.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lwh
 * @date 2023-02-14 22:18:32
 * @describe TODO
 */
public class ThreadPoolConfig {

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(5, 10, 1800,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                new ThreadFactory() {
                    private final AtomicInteger threadNum = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "threadPool-" + threadNum.getAndIncrement());
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
