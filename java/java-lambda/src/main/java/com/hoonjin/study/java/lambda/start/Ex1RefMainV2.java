package com.hoonjin.study.java.lambda.start;

import com.hoonjin.study.java.lambda.Procedure;

import java.util.Random;

public class Ex1RefMainV2 {

    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("runtime = " + (endNs - startNs) + " ns");
    }

    public static void main(String[] args) {
        Procedure dice = new Procedure() {
            @Override
            public void run() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("randomValue = " + randomValue);
            }
        };

        hello(dice);

        // v3와 동일해서 v3 생략
        hello(new Procedure() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        });
    }
}
