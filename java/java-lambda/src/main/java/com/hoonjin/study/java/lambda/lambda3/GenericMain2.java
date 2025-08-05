package com.hoonjin.study.java.lambda.lambda3;

public class GenericMain2 {

    public static void main(String[] args) {
        ObjectFunction stringFunction = s -> ((String) s).toUpperCase();
        String result1 = (String) stringFunction.apply("hello");
        System.out.println("result1 = " + result1);

        ObjectFunction numberFunction = i -> ((Integer) i) * ((Integer) i);
        Integer result2 = (Integer) numberFunction.apply(5);
        System.out.println("result2 = " + result2);
    }

    @FunctionalInterface
    interface ObjectFunction {
        Object apply(Object s);
    }

}
