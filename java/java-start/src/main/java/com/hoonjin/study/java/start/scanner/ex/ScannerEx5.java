package com.hoonjin.study.java.start.scanner.ex;

import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScannerEx5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("num1: ");
        int num1 = scanner.nextInt();
        System.out.print("num2: ");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        for (int i = num1; i <= num2; i++) {
            System.out.print(i);
            if (i != num2) {
                System.out.print(",");
            }
        }
        System.out.println();

        // for, if 없이 구현
        int min = Integer.min(num1, num2);
        int max = Integer.max(num1, num2);

        String result = IntStream.range(min, max + 1).mapToObj(String::valueOf)
            .collect(Collectors.joining(","));
        System.out.println("result = " + result);
    }
}
