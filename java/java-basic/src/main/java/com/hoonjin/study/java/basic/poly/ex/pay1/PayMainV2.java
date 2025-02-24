package com.hoonjin.study.java.basic.poly.ex.pay1;

import java.util.Scanner;

public class PayMainV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayService payService = new PayService();

        while (true) {
            System.out.print("결제수단 입력: ");
            String option = scanner.nextLine();
            if (option.equals("exit")) {
                return;
            }
            System.out.print("결제금액 입력: ");
            int amount = scanner.nextInt();
            scanner.nextLine(); // buffer 제거

            payService.processPay(option, amount);
        }
    }
}
