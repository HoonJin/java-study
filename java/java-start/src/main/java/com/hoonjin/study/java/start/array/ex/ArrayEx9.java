package com.hoonjin.study.java.start.array.ex;

import java.util.Scanner;

public class ArrayEx9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxProductCount = 10;
        String[] products = new String[maxProductCount];
        int[] productPrices = new int[maxProductCount];
        int productCount = 0;

        System.out.println("상품은 최대 10개 입력 가능");
        while (true) {
            System.out.println("1. 상품입력, 2. 결제, 3. 종료");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                if (productCount >= maxProductCount) {
                    continue;
                }
                System.out.print("상품이름 입력: ");
                products[productCount] = scanner.nextLine();
                System.out.print("상품가격 입력: ");
                int price = scanner.nextInt();
                productPrices[productCount] = price;
                productCount++;

            } else if (menu == 2) {
                for (int i = 0; i < productCount; i++) {
                    System.out.println("상품 = " + products[i]);
                    System.out.println("가격 = " + productPrices[i]);
                }
                productCount = 0;
            } else if (menu == 3) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("잘못된 입력");
            }
        }
    }
}
