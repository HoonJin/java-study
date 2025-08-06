package com.hoonjin.study.java.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringToIntegerMapper {

    public static List<Integer> map(List<String> list, Function<String, Integer> function) {
        List<Integer> mapped = new ArrayList<>();
        for (String str : list) {
            mapped.add(function.apply(str));
        }
        return mapped;
    }
}
