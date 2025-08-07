package com.hoonjin.study.java.lambda.lambda5.mystream;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MyStreamV2 {

    private final List<Integer> internals;

    public static MyStreamV2 of(List<Integer> internals) {
        return new MyStreamV2(internals);
    }

    public MyStreamV2 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer i : internals) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return new MyStreamV2(filtered);
    }

    public MyStreamV2 map(Function<Integer, Integer> function) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer i : internals) {
            mapped.add(function.apply(i));
        }
        return new MyStreamV2(mapped);
    }

    public List<Integer> toList() {
        return internals;
    }
}
