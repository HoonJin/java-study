package com.hoonjin.study.java.lambda.lambda4;

public class TriMain {

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> triFunction1 = new TriFunction<>() {
            @Override
            public Integer apply(Integer a, Integer b, Integer c) {
                return a + b + c;
            }
        };
        System.out.println("triFunction1.apply(1, 2, 3) = " + triFunction1.apply(1, 2, 3));

        TriFunction<Integer, Integer, Integer, Integer> triFunction2 = (a, b, c) -> a + b + c;
        System.out.println("triFunction2.apply(1, 2, 3) = " + triFunction2.apply(1, 2, 3));
    }
}
