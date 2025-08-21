package com.hoonjin.study.java.parallel.forkjoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.hoonjin.study.java.util.MyLogger.log;

public class CompletableFutureMain {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> log("Fork/Join"));

        try (ExecutorService es = Executors.newFixedThreadPool(100)) {
            CompletableFuture.runAsync(() -> log("Custom Pool"), es);
        }
        Thread.sleep(1000);
    }
}
