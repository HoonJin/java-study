package com.hoonjin.study.java.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV3 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> integerResult = map(list, s -> Integer.valueOf(s));
        System.out.println("integerResult = " + integerResult);

        List<Integer> lengthResult = map(list, s -> s.length());
        System.out.println("lengthResult = " + lengthResult);
    }

    private static List<Integer> map(List<String> list, Function<String, Integer> function) {
        List<Integer> mapped = new ArrayList<>();
        for (String str : list) {
            mapped.add(function.apply(str));
        }
        return mapped;
    }

}
