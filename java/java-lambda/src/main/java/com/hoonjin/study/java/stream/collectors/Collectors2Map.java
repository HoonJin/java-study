package com.hoonjin.study.java.stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {

    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Cherry", "Tomato")
            .collect(Collectors.toMap(
                name -> name,
                String::length
            ));
        System.out.println("map1 = " + map1);

        //  Duplicate key Apple (attempted merging values 5 and 5)
//        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Cherry", "Tomato")
//            .collect(Collectors.toMap(
//                name -> name,
//                String::length
//            ));
//        System.out.println("map2 = " + map2);

        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Cherry", "Tomato")
            .collect(Collectors.toMap(
                name -> name, // key mapper: 이름을 키로 사용
                String::length, // value mapper: 문자열 길이를 값으로 사용
                (existing, replacement) -> existing // 중복 키 처리: 기존 값을 유지
            ));
        System.out.println("map2 = " + map2);

        Map<String, Integer> map4 = Stream.of("Apple", "Apple", "Cherry", "Tomato")
            .collect(Collectors.toMap(
                name -> name, // key mapper: 이름을 키로 사용
                String::length, // value mapper: 문자열 길이를 값으로 사용
                (existing, replacement) -> existing, // 중복 키 처리: 기존 값을 유지
                LinkedHashMap::new // 타입 지정
            ));
        System.out.println("map4 = " + map4.getClass());
    }
}
