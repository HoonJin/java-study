package com.hoonjin.study.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.hoonjin.study.java.thread.executor.ExecutorUtils.printState;
import static com.hoonjin.study.java.util.MyLogger.log;

public class ExecutorShutdownMain {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new RunnableTask("taskA"));
        service.execute(new RunnableTask("taskB"));
        service.execute(new RunnableTask("taskC"));
        service.execute(new RunnableTask("LongTask", 100_000));
        printState(service);

        log("-- shutdown 시작");
        shutdownAndAwaitTermination(service);
        log("-- shutdown 완료");
    }

    private static void shutdownAndAwaitTermination(ExecutorService service) {
        service.shutdown(); // non - blocking - 새로운 작업 X, 처리중에 큐에 대기중인 작업은 처리한다.
        try {
            boolean result = service.awaitTermination(10_000, TimeUnit.MILLISECONDS);
            if (!result) { // 종료가 안된다면
                log("서비스 정상 종료 실패 -> 강제 종료 시도");
                service.shutdownNow();
                // 작업이 취소될 때까지 대기
                if (!service.awaitTermination(10_000, TimeUnit.MILLISECONDS)) {
                    log("서비스가 종료되지 않았습니다.");
                }
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
