package com.hoonjin.study.java.basic.oop1.ex;

public class Account {

    int balance;

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("출금 신청 금액이 잔액보다 클 수 없습니다.");
            return;
        }
        balance -= amount;
    }
}
