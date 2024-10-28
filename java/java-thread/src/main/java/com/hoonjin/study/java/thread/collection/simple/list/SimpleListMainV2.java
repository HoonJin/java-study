package com.hoonjin.study.java.thread.collection.simple.list;

import static com.hoonjin.study.java.util.MyLogger.log;

public class SimpleListMainV2 {

    public static void main(String[] args) throws InterruptedException {
//        test(new BasicList());
//        test(new SyncList());
        //
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList list) throws InterruptedException {
        Runnable task = () -> {
            list.add("A");
            log("thread-A: list.add(A)");
        };

        Runnable task1 = () -> {
            list.add("B");
            log("thread-B: list.add(B)");
        };

        Thread thread = new Thread(task);
        thread.start();
        Thread thread1 = new Thread(task1);
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("list = " + list);
    }
}
