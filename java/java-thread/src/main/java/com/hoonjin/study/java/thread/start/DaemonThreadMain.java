package com.hoonjin.study.java.thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        System.out.println(Thread.currentThread().getName() + ": before execute start()");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + ": after execute start()");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            try {
//                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + ": run()");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + ": run() end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
