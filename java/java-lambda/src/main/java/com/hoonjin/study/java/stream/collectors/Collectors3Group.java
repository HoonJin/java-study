package com.hoonjin.study.java.stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors3Group {

    public static void main(String[] args) {
        Map<String, List<String>> nameGrouped = List.of("Apple", "Avocado", "Banana", "Cherry", "BlueBerry")
            .stream()
            .collect(Collectors.groupingBy(name -> name.substring(0, 1)));
        System.out.println("nameGrouped = " + nameGrouped);

        Map<Boolean, List<Integer>> partition = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .stream()
            .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("partition = " + partition);
    }
}
