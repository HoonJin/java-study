package com.hoonjin.study.java.start.scanner.ex;

import java.util.Scanner;

public class ScannerEx4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("몇 단인지 입력하세요: ");
        int input = scanner.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(input + " * " + i + " = " + (input * i));

        }

    }
}
