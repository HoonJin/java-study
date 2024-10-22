package com.hoonjin.study.java.thread.sync.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.hoonjin.study.java.util.MyLogger.log;

public class BoundedQueueV4 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int MAX;

    public BoundedQueueV4(int max) {
        this.MAX = max;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try {
            while (queue.size() == MAX) {
                log("[PUT] queue is full " + data);
                try {
                    condition.await(); // RUNNABLE -> WAITING
                    log("[PUT] producer WAKE UP");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[PUT] call signal()");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("[TAKE] queue is empty");
                try {
                    condition.await(); // RUNNABLE -> WAITING
                    log("[TAKE] consumer WAKE UP");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String take = queue.poll();
            log("[TAKE] call signal()");
            condition.signal();
            return take;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
