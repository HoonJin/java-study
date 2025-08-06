package com.hoonjin.study.java.lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericFilter {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        ArrayList<T> filtered = new ArrayList<>();
        for (T ele : list) {
            if (predicate.test(ele)) {
                filtered.add(ele);
            }
        }
        return filtered;
    }
}
