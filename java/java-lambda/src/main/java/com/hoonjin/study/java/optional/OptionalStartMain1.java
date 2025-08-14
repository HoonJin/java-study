package com.hoonjin.study.java.optional;

import java.util.Map;
import java.util.Optional;

public class OptionalStartMain1 {

    private static final Map<Long, String> MAP = Map.of(
        1L, "one",
        2L, "two"
    );

    public static void main(String[] args) {
        findAndPrint(1L);
        findAndPrint(3L);
    }

    static void findAndPrint(Long id) {
        String name = findNameById(id);
        // NPE
//        System.out.println("name.toUpperCase() = " + name.toUpperCase());

        // 2. if 문을 활용한 null 체크
        if (name != null) {
            System.out.println(id + " : " + name.toUpperCase());
        } else {
            System.out.println(id + " : UNKNOWN");
        }
    }

    static String findNameById(Long id) {
        return MAP.get(id);
    }
}
