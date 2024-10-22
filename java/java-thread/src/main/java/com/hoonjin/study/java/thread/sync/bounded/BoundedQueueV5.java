package com.hoonjin.study.java.thread.sync.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.hoonjin.study.java.util.MyLogger.log;

public class BoundedQueueV5 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition consumerCondition = lock.newCondition();
    private final Condition producerCondition = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int MAX;

    public BoundedQueueV5(int max) {
        this.MAX = max;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try {
            while (queue.size() == MAX) {
                log("[PUT] queue is full " + data);
                try {
                    producerCondition.await(); // RUNNABLE -> WAITING
                    log("[PUT] producer WAKE UP");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[PUT] call consumerCondition.signal()");
            consumerCondition.signal();
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
                    consumerCondition.await(); // RUNNABLE -> WAITING
                    log("[TAKE] consumer WAKE UP");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String take = queue.poll();
            log("[TAKE] call producerCondition.signal()");
            producerCondition.signal();
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
