package com.hoonjin.study.java.lambda.lambda3;

public class GenericMain5 {

    public static void main(String[] args) {
        GenericFunction<String, String> stringFunction = s -> s.toUpperCase();
        String result1 = stringFunction.apply("hello");
        System.out.println("result1 = " + result1);

        GenericFunction<Integer, Integer> numberFunction = i -> i * i;
        Integer result2 = numberFunction.apply(5);
        System.out.println("result2 = " + result2);
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T t);
    }

}
