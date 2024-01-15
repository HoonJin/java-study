package com.hoonjin.study.java.start.scanner;

import java.util.Scanner;

public class Scanner1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열을 입력하세요: ");
        String str = scanner.nextLine(); // 입력을 String 으로 가져온다.
        System.out.println("str = " + str);
        System.out.println();

        System.out.print("정수를 입력하세요: ");
        int i = scanner.nextInt();
        System.out.println("i = " + i);
        System.out.println();

        System.out.print("실수를 입력하세요: ");
        double v = scanner.nextDouble();
        System.out.println("v = " + v);
        System.out.println();
    }
}
