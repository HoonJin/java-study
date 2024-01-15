package com.hoonjin.study.java.start.scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCost = 0;
        while (true) {
            System.out.println("1. 상품입력, 2. 결제, 3. 종료");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                System.out.print("상품이름 입력: ");
                String name = scanner.nextLine();
                System.out.print("상품가격 입력: ");
                int price = scanner.nextInt();
                System.out.print("상품수량 입력: ");
                int quantity = scanner.nextInt();
                totalCost = totalCost + price * quantity;
                System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity);
                System.out.println("totalCost = " + totalCost);

            } else if (menu == 2) {
                System.out.println("totalCost = " + totalCost);
                totalCost = 0;
            } else if (menu == 3) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("잘못된 입력");
            }
        }
    }
}
