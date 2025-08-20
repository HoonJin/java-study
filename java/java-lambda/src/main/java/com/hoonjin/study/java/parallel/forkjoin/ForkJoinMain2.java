package com.hoonjin.study.java.parallel.forkjoin;

import com.hoonjin.study.java.util.MyLogger;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinMain2 {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool(); // 디버그용으로 선언. 없어도 된다
        System.out.println("availableProcessors = " + availableProcessors);
        System.out.println("commonPool = " + commonPool);

        List<Integer> data = IntStream.rangeClosed(1, 8).boxed().toList();
        SumTask task = new SumTask(data);

        Integer sum = task.invoke();
        MyLogger.log("sum: " + sum);

        MyLogger.log("commonPool = " + commonPool);
    }
}
