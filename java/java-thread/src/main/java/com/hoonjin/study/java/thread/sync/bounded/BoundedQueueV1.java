package com.hoonjin.study.java.thread.sync.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.hoonjin.study.java.util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque();
    private final int MAX;

    public BoundedQueueV1(int max) {
        this.MAX = max;
    }

    @Override
    public synchronized void put(String data) {
        if (queue.size() == MAX) {
            log("queue is full " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
