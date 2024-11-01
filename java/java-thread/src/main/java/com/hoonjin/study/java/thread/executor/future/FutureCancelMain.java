package com.hoonjin.study.java.thread.executor.future;

import java.util.concurrent.*;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class FutureCancelMain {

    private static boolean mayInterruptIfRunning = true;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(new MyTask());

        System.out.println("future.state() = " + future.state());

        sleep(3000);

        log("future.cancel(" + mayInterruptIfRunning + ")");
        boolean cancelResult = future.cancel(mayInterruptIfRunning);
        log("future.cancel(" + mayInterruptIfRunning + ") Result = " + cancelResult);

        try {
            log("future result = " + future.get());
        } catch (CancellationException e) {
            log("already canceled future task");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.close();
        }
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call() {
            try {
                for (int i = 0; i < 10; i++) {
                    log("working in progress " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                log("interrupted");
                return "interrupted";
            }
            return "success";
        }
    }
}
