package com.hoonjin.study.java.thread.executor.future;

import java.util.concurrent.*;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class FutureExceptionMain {

    static Callable<String> task = () -> {
        log("exception occurred");
        throw new IllegalStateException("exception occurred");
    };

    public static void main(String[] args) {
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<String> future = service.submit(task);
            sleep(1000);
            log("future.state() = " + future.state());
            log("future result = " + future.get());
        } catch (InterruptedException e) {
            log("interrupted exception");
        } catch (ExecutionException e) {
            log("e = " + e);
            Throwable cause = e.getCause();
            log("cause = " + cause);
        }
    }
}
