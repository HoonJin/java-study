package com.hoonjin.study.java.start.method.ex;

public class MethodEx3Ref {

    public static void main(String[] args) {
        int balance = 10000;
        balance = deposit(balance, 2000);
        balance = withdraw(balance, 500);
        System.out.println("balance = " + balance);
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
