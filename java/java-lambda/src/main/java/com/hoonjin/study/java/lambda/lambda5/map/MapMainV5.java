package com.hoonjin.study.java.lambda.lambda5.map;

import java.util.List;

public class MapMainV5 {

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "orange");

        // string -> string
        List<String> upperResult = GenericMapper.map(list, s -> s.toUpperCase());
        System.out.println("upperResult = " + upperResult);

        // string -> integer
        List<Integer> lengthResult = GenericMapper.map(list, s -> s.length());
        System.out.println("lengthResult = " + lengthResult);

        // integer -> string
        List<Integer> integers = List.of(1, 2, 3, 5);
        List<String> starResult = GenericMapper.map(integers, i -> "*".repeat(i));
        System.out.println("starResult = " + starResult);
    }
}
