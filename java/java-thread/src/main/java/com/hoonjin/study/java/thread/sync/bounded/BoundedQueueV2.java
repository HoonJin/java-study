package com.hoonjin.study.java.thread.sync.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int MAX;

    public BoundedQueueV2(int max) {
        this.MAX = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() == MAX) {
            log("[put] queue is full " + data);
            sleep(1000);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] queue is empty");
            sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
