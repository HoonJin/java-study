package com.hoonjin.study.java.stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Collectors1Basic {

    public static void main(String[] args) {
        List<String> list = Stream.of("Java", "Spring", "JPA")
            .collect(toList()); // 수정 가능 리스트
        System.out.println("list = " + list);

        List<String> unmodifiableList = Stream.of("Java", "Spring", "JPA")
            .collect(toUnmodifiableList()); // 수정 불가능 리스트;
        System.out.println("unmodifiableList = " + unmodifiableList);

        Set<Integer> set = Stream.of(1, 2, 3, 3, 4, 5)
            .collect(toSet());// 중복 제거
        System.out.println("set = " + set);

        TreeSet<Integer> tree = Stream.of(3, 4, 5, 2, 1)
            .collect(toCollection(TreeSet::new)); // 정렬된 트리셋
        System.out.println("tree = " + tree);

    }
}
