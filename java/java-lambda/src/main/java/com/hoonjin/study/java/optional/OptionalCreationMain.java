package com.hoonjin.study.java.optional;

import java.util.Optional;

public class OptionalCreationMain {

    public static void main(String[] args) {
        // 1. Optional.of() : null이 아닌 값을 감싸는 Optional 객체 생성, null이면 NPE 예외 발생
        String nonNullValue = "Hello Optional";
        Optional<String> opt1 = Optional.of(nonNullValue);
        System.out.println("opt1 = " + opt1);

        // 2. Optional.ofNullable() : null일 수도 있는 값을 감싸는 Optional 객체 생성
        Optional<String> opt2 = Optional.ofNullable("hello");
        System.out.println("opt2 = " + opt2);

        Optional<String> opt3 = Optional.ofNullable(null); // null이면 비어있는 Optional 객체 생성
        System.out.println("opt3 = " + opt3);

        // 3. Optional.empty() : 비어있는 Optional 객체 생성
        Optional<Object> opt4 = Optional.empty();
        System.out.println("opt4 = " + opt4);
    }
}
