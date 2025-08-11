package com.hoonjin.study.java.stream.basic;

import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        List<Integer> origins = List.of(1, 2, 3, 4);
        System.out.println("origins = " + origins);

        List<Integer> filtered = origins.stream()
            .filter(value -> value % 2 == 0)
            .toList();
        System.out.println("filtered = " + filtered);
        System.out.println("원본 리스트는 변하지 않는다.");
        System.out.println("origins = " + origins);
    }
}
