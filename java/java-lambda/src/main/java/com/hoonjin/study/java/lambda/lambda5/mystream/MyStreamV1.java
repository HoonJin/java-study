package com.hoonjin.study.java.lambda.lambda5.mystream;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class MyStreamV1 {

    private final List<Integer> internals;

    public MyStreamV1 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer i : internals) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return new MyStreamV1(filtered);
    }

    public MyStreamV1 map(Function<Integer, Integer> function) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer i : internals) {
            mapped.add(function.apply(i));
        }
        return new MyStreamV1(mapped);
    }

    public List<Integer> toList() {
        return internals;
    }
}
