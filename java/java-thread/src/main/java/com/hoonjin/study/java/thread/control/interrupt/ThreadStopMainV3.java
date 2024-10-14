package com.hoonjin.study.java.thread.control.interrupt;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        sleep(20);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("thread is interrupted 1 = " + thread.isInterrupted());
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // interrupt 상태 변경 X
                log("processing");
            }
            log("thread is interrupted 2 = " + Thread.currentThread().isInterrupted());
            log("state = " + Thread.currentThread().getState());

            try {
                log("cleaning");
                Thread.sleep(100);
                log("end");
            } catch (InterruptedException e) {
                log("자원 정리 중 인터럽트 발생으로 실패");
                log("thread is interrupted 3 = " + Thread.currentThread().isInterrupted());
            }

            log("FIN");
        }
    }
}
