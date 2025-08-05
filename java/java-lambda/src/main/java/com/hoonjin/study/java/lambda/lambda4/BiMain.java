package com.hoonjin.study.java.lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add1 = (x, y) -> x + y;
        System.out.println("add1.apply(3, 4) = " + add1.apply(3, 4));

        BiConsumer<String, Integer> repeat = (c, num) -> {
            for (int i = 0; i < num; i++) {
                System.out.print(c);
            }
            System.out.println();
        };
        repeat.accept("*", 5);

        BiPredicate<Integer, Integer> isGreater = (x, y) -> x > y;
        System.out.println("isGreater.test(10, 5) = " + isGreater.test(10, 5));
    }
}
