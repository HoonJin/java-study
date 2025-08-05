package com.hoonjin.study.java.lambda.lambda4;

import java.util.function.Consumer;

public class ConsumerMain {

    public static void main(String[] args) {
        Consumer<String> consumer1 = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };
        consumer1.accept("hello");

        Consumer<String> consumer2 = s -> System.out.println("s = " + s);
        consumer2.accept("hello");
    }
}
