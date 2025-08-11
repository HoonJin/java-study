package com.hoonjin.study.java.stream.basic;

import java.util.List;
import java.util.stream.Stream;

public class DuplicateExecutionMain {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        stream.forEach(System.out::println); // 1. 최초실행

//        stream.forEach(System.out::println); // 2. stream 중복 실행하면 예외 발생

        List<Integer> list = List.of(1, 2, 3, 4);
        Stream.of(list).forEach(System.out::println);
        // 새로운 스트림 객체는 위에서 만든 스트림과 다른객체이다.
        Stream.of(list).forEach(System.out::println);
    }
}
