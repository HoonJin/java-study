package com.hoonjin.study.java.thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("value = " + value);
            log("Runnable 완료");
            return value;
        };

        ExecutorService service = Executors.newFixedThreadPool(1);

        Future<Integer> future = service.submit(callable);
        Integer result = future.get();
        log("result = " + result);
        service.close();
    }
}
