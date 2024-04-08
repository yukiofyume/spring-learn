package com.lwh.learn.thread.pool;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lwh
 * @date 2024-03-30 19:31:14
 * @describe -
 */
public class NamedThreadFactory implements ThreadFactory {

    protected static final AtomicInteger POOL_SEQ = new AtomicInteger(1);

    protected final AtomicInteger threadNum = new AtomicInteger(1);

    protected final String prefix;

    protected final boolean daemon;

    protected final ThreadGroup group;

    public NamedThreadFactory() {
        this("pool-" + POOL_SEQ.getAndIncrement(), false);
    }

    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }

    public NamedThreadFactory(String prefix, boolean daemon) {
        this.prefix = prefix;
        this.daemon = daemon;
        SecurityManager securityManager = System.getSecurityManager();
        this.group = Objects.isNull(securityManager) ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        String name = this.prefix + this.threadNum.getAndIncrement();
        Thread ret = new Thread(this.group, runnable, name, 0);
        ret.setDaemon(daemon);
        return ret;
    }

    public ThreadGroup getThreadGroup() {
        return group;
    }

    public AtomicInteger getThreadNum() {
        return threadNum;
    }
}
