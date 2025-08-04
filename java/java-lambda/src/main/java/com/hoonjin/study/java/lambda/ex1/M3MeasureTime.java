package com.hoonjin.study.java.lambda.ex1;

import com.hoonjin.study.java.lambda.Procedure;

import java.util.Arrays;
import java.util.stream.LongStream;

public class M3MeasureTime {

    public static void measure(Procedure procedure) {
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("runtime = " + (endNs - startNs) + " ns");
    }

    public static void main(String[] args) {
        Procedure sum = () -> {
            long result = LongStream.range(1, 100).sum();
            System.out.println("result = " + result);
        };

        measure(sum);
        measure(() -> {
            int[] arrays = {3, 1, 5, 2, 4};
            System.out.println("arrays = " + Arrays.toString(arrays));
            Arrays.sort(arrays);
            System.out.println("sorted arrays = " + Arrays.toString(arrays));
        });
    }
}
