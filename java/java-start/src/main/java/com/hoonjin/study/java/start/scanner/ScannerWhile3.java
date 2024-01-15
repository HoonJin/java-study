package com.hoonjin.study.java.start.scanner;

import java.util.Scanner;

public class ScannerWhile3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        while (true) {
            System.out.print("숫자 입력 (0 종료): ");
            int i = scanner.nextInt();

            if (i == 0) {
                break;
            }
            sum += i;
        }

        System.out.println("sum = " + sum);
    }
}
