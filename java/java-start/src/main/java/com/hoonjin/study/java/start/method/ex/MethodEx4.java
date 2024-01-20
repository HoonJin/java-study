package com.hoonjin.study.java.start.method.ex;

import java.util.Scanner;

public class MethodEx4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 0;
        while (true) {
            System.out.println("1. deposit, 2. withdraw, 3. inquiry, 4. exit");
            System.out.print("input: ");
            int menu = scanner.nextInt();
            if (menu == 1) {
                System.out.print("amount: ");
                int amount = scanner.nextInt();
                balance = deposit(balance, amount);
            } else if (menu == 2) {
                System.out.print("amount: ");
                int amount = scanner.nextInt();
                balance = withdraw(balance, amount);
            } else if (menu == 3) {
                System.out.println("balance = " + balance);
            } else if (menu == 4) {
                break;
            } else {
                System.out.println("unexpected menu;");
            }
        }
    }

    public static int deposit(int balance, int amount) {
        System.out.println("deposit amount = " + amount);
        return balance + amount;
    }

    public static int withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("withdraw amount = " + amount);
        } else {
            System.out.println("not enough balance");
        }
        return balance;
    }
}
