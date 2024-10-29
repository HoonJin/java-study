package com.hoonjin.study.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class ExecutorBasicMain {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        log("==초기 상태==");
        ExecutorUtils.printState(service);
        service.execute(new RunnableTask("taskA"));
        service.execute(new RunnableTask("taskB"));
        service.execute(new RunnableTask("taskC"));
        service.execute(new RunnableTask("taskD"));

        log("==작업 실행중==");
        ExecutorUtils.printState(service);

        sleep(3000);

        log("==작업 완료==");
        ExecutorUtils.printState(service);

        service.close();
        log("==shutdown 완료==");
        ExecutorUtils.printState(service);
    }
}
