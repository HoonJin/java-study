package com.hoonjin.study.java.start.scanner;

import java.util.Scanner;

public class ScannerWhile1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("문자열 입력 (exit 종료): ");
            String str = scanner.nextLine();

            if (str.equals("exit")) {
                System.out.println("exited");
                break;
            }

            System.out.println("str = " + str);
        }
    }
}
