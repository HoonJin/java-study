package com.hoonjin.study.java.thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class CallableMainV2 {

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
        log("submit() 호출");
        Future<Integer> future = service.submit(callable);
        log("future 즉시반환 = " + future);

        log("future.get() 호출 시작 -> main thread state = WAITING");
        Integer result = future.get();
        log("future.get() 호출 시작 -> main thread state = RUNNABLE");
        log("result = " + result);
        log("future 최종 = " + future);

        service.close();
    }
}
