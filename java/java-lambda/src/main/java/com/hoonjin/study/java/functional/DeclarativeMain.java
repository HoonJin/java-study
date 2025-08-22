package com.hoonjin.study.java.functional;

import java.util.ArrayList;
import java.util.List;

public class DeclarativeMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> resul1 = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                resul1.add(number * number);
            }
        }
        System.out.println("Imperative resul1 = " + resul1);

        List<Integer> result2 = numbers.stream()
            .filter(number -> number % 2 == 0)
            .map(number -> number * number)
            .toList();
        System.out.println("Declarative result2 = " + result2);
    }
}
