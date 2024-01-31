package com.hoonjin.study.java.basic.access;

public class BankAccount {

    private int balance;


    public BankAccount() {
        balance = 0;
    }

    public void deposit(int amount) {
        if (isAmountValid(amount)) {
            balance += amount;
        } else {
            System.out.println("invalid amount");
        }
    }

    private boolean isAmountValid(int amount) {
        return amount > 0;
    }

    public void withdraw(int amount) {
        if (isAmountValid(amount) && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("invalid amount or not enough balance");
        }
    }

    public int getBalance() {
        return balance;
    }
}
