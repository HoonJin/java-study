package com.hoonjin.study.java.optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        System.out.println("1. ifPresent() - 값이 있으면 실행, 없으면 무시");
        optValue.ifPresent(v -> System.out.println("Value: " + v));
        optEmpty.ifPresent(v -> System.out.println("Empty: " + v)); // 실행이 안됨

        System.out.println("2. ifPresentOrElse() - 값이 있으면 실행, 없으면 다른 동작 실행");
        optValue.ifPresentOrElse(
            v -> System.out.println("Value: " + v),
            () -> System.out.println("No value present")
        );
        optEmpty.ifPresentOrElse(
            v -> System.out.println("Value: " + v),
            () -> System.out.println("No value present")
        );

        System.out.println("3. map() - 값을 변환, 없으면 비어있는 Optional 반환");
        Optional<Integer> optLength = optValue.map(String::length);
        System.out.println("optLength = " + optLength);
        Optional<Integer> optEmptyLength = optEmpty.map(String::length);
        System.out.println("optEmptyLength = " + optEmptyLength);

        System.out.println("4. flatMap() - Optional 안의 값을 변환, 중첩된 Optional을 평탄화");
        Optional<Optional<String>> nestedOpt = optValue.map(Optional::of);
        System.out.println("nestedOpt = " + nestedOpt);
        Optional<String> flatOpt = optValue.flatMap(Optional::of);
        System.out.println("flatOpt = " + flatOpt);


        System.out.println("5. filter() - 조건에 맞는 값만 남김, 없으면 비어있는 Optional 반환");
        Optional<String> filteredOpt1 = optValue.filter(v -> v.startsWith("H"));
        System.out.println("filter(H) = " + filteredOpt1);
        Optional<String> filteredOpt2 = optValue.filter(v -> v.startsWith("X"));
        System.out.println("filter(X) = " + filteredOpt2);

        System.out.println("6. stream() - Optional을 Stream으로 변환");
        optValue.stream()
            .forEach(v -> System.out.println("Stream value: " + v));

        optEmpty.stream()
            .forEach(v -> System.out.println("Stream empty value: " + v)); // 실행이 안됨
    }
}
