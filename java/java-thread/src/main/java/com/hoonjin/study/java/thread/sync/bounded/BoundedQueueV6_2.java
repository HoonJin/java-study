package com.hoonjin.study.java.thread.sync.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.hoonjin.study.java.util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {

    private final BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        boolean result = queue.offer(data);
        log("offer result = " + result);
    }

    @Override
    public String take() {
        String data = queue.poll();
        log("poll result = " + data);
        return data;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
