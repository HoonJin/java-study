package com.hoonjin.study.java.thread.sync.test;

public class SyncTest1BadMain {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
        System.out.println("counter.getCount() = " + counter.getCount());

    }

    static class Counter {
        private int count = 0;
        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
