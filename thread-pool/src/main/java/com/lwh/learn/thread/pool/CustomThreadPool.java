package com.lwh.learn.thread.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lwh
 * @date 2024-03-30 19:42:46
 * @describe -
 */
public class CustomThreadPool {


    /**
     *
     * @param threadPoolPrefixName 线程池前缀
     * @param threadPoolSize 最大和核心数量设置为一样
     * @param keepAliveTime 单位毫秒
     * @param queueSize 阻塞队列大小
     * @return
     */
    public ThreadPoolExecutor initThreadPool(String threadPoolPrefixName,
                                             int threadPoolSize,
                                             long keepAliveTime,
                                             int queueSize) {
        return new ThreadPoolExecutor(threadPoolSize,
                threadPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(queueSize),
                new NamedThreadFactory(threadPoolPrefixName));
    }

}
