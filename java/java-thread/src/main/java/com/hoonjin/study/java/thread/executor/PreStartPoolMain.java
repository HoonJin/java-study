package com.hoonjin.study.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static com.hoonjin.study.java.thread.executor.ExecutorUtils.printState;

public class PreStartPoolMain {

    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(100)) {
            printState(service);

            ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
            executor.prestartAllCoreThreads();
            printState(service);
        }
    }
}
