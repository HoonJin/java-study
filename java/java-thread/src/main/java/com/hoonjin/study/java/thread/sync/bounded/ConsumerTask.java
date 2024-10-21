package com.hoonjin.study.java.thread.sync.bounded;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ConsumerTask implements Runnable {

    private BoundedQueue boundedQueue;

    public ConsumerTask(BoundedQueue boundedQueue) {
        this.boundedQueue = boundedQueue;
    }

    @Override
    public void run() {
        log("[consume] start -    ?" + " <- " + boundedQueue);
        String take = boundedQueue.take();
        log("[consume] end - " + take + " <- " + boundedQueue);
    }
}
