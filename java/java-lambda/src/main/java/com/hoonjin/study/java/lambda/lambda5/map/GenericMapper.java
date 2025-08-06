package com.hoonjin.study.java.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMapper {

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> mapped = new ArrayList<>();
        for (T ele : list) {
            mapped.add(function.apply(ele));
        }
        return mapped;
    }
}
