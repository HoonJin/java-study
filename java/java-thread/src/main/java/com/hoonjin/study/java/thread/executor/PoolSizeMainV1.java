package com.hoonjin.study.java.thread.executor;

import java.util.concurrent.*;

import static com.hoonjin.study.java.thread.executor.ExecutorUtils.printState;
import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class PoolSizeMainV1 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);

        try (ExecutorService service = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, queue)) {
            printState(service);

            service.submit(new RunnableTask("task0"));
            printState(service, "task0");

            service.submit(new RunnableTask("task1"));
            printState(service, "task1");

            service.submit(new RunnableTask("task2"));
            printState(service, "task2");

            service.submit(new RunnableTask("task3"));
            printState(service, "task3");

            service.submit(new RunnableTask("task4"));
            printState(service, "task4");

            service.submit(new RunnableTask("task5"));
            printState(service, "task5");

            try {
                service.submit(new RunnableTask("task6"));
                printState(service, "task6");
            } catch (RejectedExecutionException e) {
                log("task6 is rejected: "+ e);
            }

            sleep(3000);
            log("=== process is end ===");
            printState(service);

            sleep(3000);
            log("=== maximum pool 대기시간 초과 ===");
            printState(service);

            service.close(); // 종료후 상태를 보기 위한 종료
            log("=== shutdown ===");
            printState(service);
        }
    }
}
