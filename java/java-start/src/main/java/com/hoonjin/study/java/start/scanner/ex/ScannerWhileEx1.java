package com.hoonjin.study.java.start.scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("이름을 입력하세요 (종료 입력시 종료): ");
            String name = scanner.nextLine();

            if (name.equals("종료")) {
                System.out.println("프로그램 종료");
                break;
            }

            System.out.print("나이를 입력하세요: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // 기존에 읽은 \n을 비워주기 위해 읽음

            System.out.println("name = " + name + ", age = " + age);
        }
    }
}
