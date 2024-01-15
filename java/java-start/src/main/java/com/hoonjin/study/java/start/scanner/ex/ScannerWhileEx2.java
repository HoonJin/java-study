package com.hoonjin.study.java.start.scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("상품의 가격 입력하세요 (-1 입력시 종료): ");
            int price = scanner.nextInt();

            if (price == -1) {
                System.out.println("프로그램 종료");
                break;
            }

            System.out.print("상품의 수량을 입력하세요: ");
            int quantity = scanner.nextInt();

            int total = price * quantity;
            System.out.println("total = " + total);

        }
    }
}
