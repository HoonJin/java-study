package com.hoonjin.study.java.lambda.lambda5.mystream;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MyStreamV3<T> {

    private final List<T> internals;

    public static <T> MyStreamV3<T> of(List<T> internals) {
        return new MyStreamV3<>(internals);
    }

    public MyStreamV3<T> filter(Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T i : internals) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return MyStreamV3.of(filtered);
    }

    public <R> MyStreamV3<R> map(Function<T, R> function) {
        List<R> mapped = new ArrayList<>();
        for (T i : internals) {
            mapped.add(function.apply(i));
        }
        return MyStreamV3.of(mapped);
    }

    public List<T> toList() {
        return internals;
    }

    public void forEach(Consumer<T> consumer) {
        for (T i : internals) {
            consumer.accept(i);
        }
    }

    public T getFirst() {
        return internals.getFirst();
    }
}
