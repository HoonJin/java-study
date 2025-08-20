package com.hoonjin.study.java.parallel.forkjoin;

import com.hoonjin.study.java.parallel.HeavyJob;
import com.hoonjin.study.java.util.MyLogger;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@RequiredArgsConstructor
public class SumTask extends RecursiveTask<Integer> {
//    private static final int THRESHOLD = 4;
    private static final int THRESHOLD = 2;

    private final List<Integer> list;

    @Override
    protected Integer compute() {
        // 작업 범위가 작으면 직접 계산
        if (list.size() <= THRESHOLD) {
            MyLogger.log("[처리 시작]: " + list);
            int sum = list.stream().mapToInt(HeavyJob::heavyTask).sum();
            MyLogger.log("[처리 완료]: " + list + " -> " + sum);
            return sum;
        } else {
            // 작업 범위를 나누어 병렬 처리
            int mid = list.size() / 2;
            SumTask leftTask = new SumTask(list.subList(0, mid));
            SumTask rightTask = new SumTask(list.subList(mid, list.size()));
            MyLogger.log("[작업 분할]: " + list + " -> left: " + leftTask.list + ", right: " + rightTask.list);

            // 왼쪽 작업을 비동기로 실행하고 오른쪽 작업은 동기적으로 실행
            leftTask.fork();
            int rightResult = rightTask.compute();
            int leftResult = leftTask.join();
            MyLogger.log("[작업 병합]: leftResult: [" + leftResult + "], rightResult: [" + rightResult + "]");

            return leftResult + rightResult;
        }
    }
}
