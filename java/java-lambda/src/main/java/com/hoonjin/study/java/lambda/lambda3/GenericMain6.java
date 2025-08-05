package com.hoonjin.study.java.lambda.lambda3;

public class GenericMain6 {

    public static void main(String[] args) {
        GenericFunction<String, String> uppercase = s -> s.toUpperCase();
        GenericFunction<String, Integer> stringLength = s -> s.length();
        GenericFunction<Integer, Integer> square = i -> i * i;
        GenericFunction<Integer, Boolean> isEven = i -> i % 2 == 0;

        System.out.println("uppercase.apply(\"hello\") = " + uppercase.apply("hello"));
        System.out.println("stringLength.apply(\"hello\") = " + stringLength.apply("hello"));
        System.out.println("square.apply(3) = " + square.apply(3));
        System.out.println("isEven.apply(4) = " + isEven.apply(4));
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T t);
    }

}
