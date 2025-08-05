package com.hoonjin.study.java.lambda.lambda3;

import java.util.function.Function;

public class TargetType2 {

    public static void main(String[] args) {
        Function<String, String> uppercase = s -> s.toUpperCase();
        System.out.println("uppercase.apply(\"hello\") = " + uppercase.apply("hello"));

        Function<Integer, Integer> square = i -> i * i;
        System.out.println("square.apply(3) = " + square.apply(3));
    }

}
