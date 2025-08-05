package com.hoonjin.study.java.lambda.lambda3;

public class GenericMain1 {

    public static void main(String[] args) {
        StringFunction stringFunction = s -> s.toUpperCase();
        System.out.println("stringFunction.apply(\"hello\") = " + stringFunction.apply("hello"));

        NumberFunction numberFunction = i -> i * i;
        System.out.println("numberFunction.apply(5) = " + numberFunction.apply(5));
    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String s);
    }

    @FunctionalInterface
    interface NumberFunction {
        Integer apply(Integer i);
    }
}
