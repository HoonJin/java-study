package com.hoonjin.study.java.start.scanner;

import java.util.Scanner;

public class Scanner3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 숫자를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("두번째 숫자를 입력하세요: ");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.println("큰 숫자 = " + num1);
        } else if (num1 < num2) {
            System.out.println("큰 숫자 = " + num2);
        } else {
            System.out.println("두 숫자는 같습니다.");
        }
    }
}
