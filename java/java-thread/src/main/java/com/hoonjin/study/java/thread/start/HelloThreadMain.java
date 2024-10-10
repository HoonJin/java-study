package com.hoonjin.study.java.thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        System.out.println(Thread.currentThread().getName() + ": before execute start()");
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": after execute start()");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
