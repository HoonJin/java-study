package com.hoonjin.study.java.thread.executor.poolsize;

import com.hoonjin.study.java.thread.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.hoonjin.study.java.thread.executor.ExecutorUtils.printState;
import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class PoolSizeMainV3 {

    public static void main(String[] args) {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            // return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            //                                      60L, TimeUnit.SECONDS,
            //                                      new SynchronousQueue<Runnable>());
            log("pool 생성");
            printState(service);

            for (int i = 0; i < 6; i++) {
                String taskName = "task" + i;
                service.submit(new RunnableTask(taskName));
                printState(service, taskName);
            }
            sleep(3000);
            log("=== 작업 수행 완료 ===");
            printState(service);

            sleep(60000);
            log("=== maximum pool size 대기시간 초과 ===");
            printState(service);
        }
    }
}
