package com.hoonjin.study.java.lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MapExampleEx2 {

    static List<String> map(List<String> list, UnaryOperator<String> function) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(function.apply(s));
        }
        return result;
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

}
