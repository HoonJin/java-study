package com.hoonjin.study.java.lambda.start;

import com.hoonjin.study.java.lambda.Procedure;

import java.util.Random;

public class Ex1RefMainV4 {

    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("runtime = " + (endNs - startNs) + " ns");
    }

    public static void main(String[] args) {
        hello(() -> {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("randomValue = " + randomValue);
        });

        hello(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        });
    }
}
