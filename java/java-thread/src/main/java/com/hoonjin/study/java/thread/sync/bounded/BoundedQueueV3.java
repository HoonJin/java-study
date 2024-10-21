package com.hoonjin.study.java.thread.sync.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.hoonjin.study.java.util.MyLogger.log;

public class BoundedQueueV3 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int MAX;

    public BoundedQueueV3(int max) {
        this.MAX = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() == MAX) {
            log("[PUT] queue is full " + data);
            try {
                wait(); // RUNNABLE -> WAITING
                log("[PUT] producer WAKE UP");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        notify();
        log("[PUT] call NOTIFY");
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[TAKE] queue is empty");
            try {
                wait(); // RUNNABLE -> WAITING
                log("[TAKE] consumer WAKE UP");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String take = queue.poll();
        log("[TAKE] call NOTIFY");
        notify();
        return take;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
