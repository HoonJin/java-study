package com.hoonjin.study.java.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> integerResult = mapStringToInteger(list);
        System.out.println("integerResult = " + integerResult);

        List<Integer> lengthResult = mapStringToLength(list);
        System.out.println("lengthResult = " + lengthResult);
    }

    private static List<Integer> mapStringToLength(List<String> list) {
        List<Integer> mapped = new ArrayList<>();
        for (String str : list) {
            mapped.add(str.length());
        }
        return mapped;
    }

    private static List<Integer> mapStringToInteger(List<String> list) {
        List<Integer> mapped = new ArrayList<>();
        for (String str : list) {
            mapped.add(Integer.valueOf(str));
        }
        return mapped;
    }
}
