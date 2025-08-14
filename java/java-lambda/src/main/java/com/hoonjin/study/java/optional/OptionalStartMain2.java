package com.hoonjin.study.java.optional;

import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {

    private static final Map<Long, String> MAP = Map.of(
        1L, "one",
        2L, "two"
    );

    public static void main(String[] args) {
        findAndPrint(1L);
        findAndPrint(3L);
    }

    static void findAndPrint(Long id) {
        Optional<String> optName = findNameById(id);
        String name = optName.orElse("UNKNOWN");
        System.out.println(id + " : " + name.toUpperCase());
    }

    static Optional<String> findNameById(Long id) {
        return Optional.ofNullable(MAP.get(id));
    }
}
