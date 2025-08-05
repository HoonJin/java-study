package com.hoonjin.study.java.lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class MapExample {

    static List<String> map(List<String> list, StringFunction function) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(function.apply(s));
        }
        return result;
//        return list.stream().map(function::apply).toList();
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "world", "java", "lambda");
        System.out.println("words = " + words);

//        List<String> uppercase = map(words, s -> s.toUpperCase());
        List<String> uppercase = map(words, String::toUpperCase);
        System.out.println("uppercase = " + uppercase);

        List<String> decorated = map(words, s -> "***" + s + "***");
        System.out.println("decorated = " + decorated);
    }

    @FunctionalInterface
    interface StringFunction {

        String apply(String s);
    }
}
