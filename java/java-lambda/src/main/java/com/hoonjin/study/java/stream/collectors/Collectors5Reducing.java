package com.hoonjin.study.java.stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors5Reducing {

    public static void main(String[] args) {
        var names = List.of("a", "b", "c", "d");

        // 모든 이름을 하나의 문자열로 이어 붙이기
        String joined1 = names.stream()
            .collect(Collectors.reducing((s1, s2) -> s1 + ", " + s2))
            .get();
        System.out.println("joined1 = " + joined1);

        String joined2 = names.stream()
            .reduce((s1, s2) -> s1 + ", " + s2)
            .get();
        System.out.println("joined2 = " + joined2);

        String joined3 = names.stream().collect(Collectors.joining(", "));
        System.out.println("joined3 = " + joined3);

        String joined4 = String.join(", ", names);
        System.out.println("joined4 = " + joined4);
    }
}
