package com.hoonjin.study.java.start.scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int n = 0;
//        while (true) {
//            System.out.print("숫자를 입력하세요 (-1 입력시 종료): ");
//            int i = scanner.nextInt();
//
//            if (i == -1) {
//                System.out.println("프로그램 종료");
//                break;
//            }
//
//            sum += i;
//            n += 1;
//        }

        int input;
        while ((input = scanner.nextInt()) != -1) {
            sum += input;
            n++;
        }

        System.out.println("sum = " + sum);
        double average = (double) sum / n;
        System.out.println("average = " + average);
    }
}
