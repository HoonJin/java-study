package com.hoonjin.study.java.stream.operation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MapVsFlatMapMain {

    public static void main(String[] args) {
        List<List<Integer>> outerList = List.of(
            List.of(1, 2),
            List.of(3, 4),
            List.of(5, 6)
        );

        // for
        List<Integer> forResult = new ArrayList<>();
        for (List<Integer> innerList : outerList) {
//            for (Integer i : innerList) {
//                result.add(i);
//            }
            forResult.addAll(innerList);
        }
        System.out.println("forResult = " + forResult);


        List<Integer> flatMapResult = outerList.stream()
            .flatMap(Collection::stream).toList();
        System.out.println("flatMapResult = " + flatMapResult);
    }
}
