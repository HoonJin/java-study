package com.hoonjin.study.java.optional;

import java.util.Optional;

public class OptionalRetrievalMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("hello");
        Optional<String> optEmpty = Optional.empty();

        System.out.println("1. isPresent() and isEmpty()");
        System.out.println("optValue.isPresent() = " + optValue.isPresent());
        System.out.println("optEmpty.isPresent() = " + optEmpty.isPresent());
        System.out.println("optEmpty.isEmpty() = " + optEmpty.isEmpty());

        System.out.println("2. get() - 값을 반환, 없으면 NoSuchElementException 예외 발생");
        System.out.println("optValue.get() = " + optValue.get());
        // System.out.println("optEmpty.get() = " + optEmpty.get()); // 예외 발생

        System.out.println("3. orElse() - 값이 있으면 반환, 없으면 기본값 반환");
        String value1 = optValue.orElse("default");
        String empty1 = optEmpty.orElse("default");
        System.out.println("optValue.orElse(\"default\") = " + value1);
        System.out.println("optEmpty.orElse(\"default\") = " + empty1);

        System.out.println("4. orElseGet() - 값이 있으면 반환, 없으면 Supplier를 통해 기본값 생성");
        String value2 = optValue.orElseGet(() -> "New Value");
        String empty2 = optEmpty.orElseGet(() -> "New Value");
        System.out.println("value2 = " + value2);
        System.out.println("empty2 = " + empty2);

        System.out.println("5. orElseThrow() - 값이 있으면 반환, 없으면 예외 발생");
        String value3 = optValue.orElseThrow();
        System.out.println("value3 = " + value3);

        try {
            String s = optEmpty.orElseThrow(() -> new RuntimeException("Value is missing"));
            System.out.println("s = " + s);
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        System.out.println("6. or() - 값이 있으면 반환, 없으면 다른 Optional을 반환");
        Optional<String> value4 = optValue.or(() -> Optional.of("Fallback"));
        Optional<String> empty4 = optEmpty.or(() -> Optional.of("Fallback"));
        System.out.println("value4 = " + value4);
        System.out.println("empty4 = " + empty4);

    }
}
