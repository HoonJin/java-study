package com.hoonjin.study.java.start.scanner.ex;

import java.util.Scanner;

public class ScannerEx3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("가격을 입력하세요: ");
        int price = scanner.nextInt();
        System.out.print("수량을 입력하세요: ");
        int quantity = scanner.nextInt();

        System.out.println("name = " + name);

        int total = price * quantity;
        System.out.println(name + " total = " + total);

    }
}
