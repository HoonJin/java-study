package com.hoonjin.study.java.thread.control;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {  // 가능
        throw new Exception();
    }

    static class CheckedExceptionRunnable implements Runnable {
        @Override
//        public void run() throws Exception {  // 불가능
        public void run() {
//            throw new Exception();
            throw new RuntimeException();
        }
    }
}
