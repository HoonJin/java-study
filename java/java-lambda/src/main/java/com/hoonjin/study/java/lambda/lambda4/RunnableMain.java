package com.hoonjin.study.java.lambda.lambda4;

public class RunnableMain {

    public static void main(String[] args) {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, Anonymous Runnable!");
            }
        };
        runnable1.run();

        Runnable runnable2 = () -> System.out.println("Hello, Lambda Runnable!");
        runnable2.run();
    }
}
