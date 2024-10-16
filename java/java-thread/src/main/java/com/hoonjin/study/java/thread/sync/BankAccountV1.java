package com.hoonjin.study.java.thread.sync;

import lombok.Getter;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class BankAccountV1 implements BankAccount {

    @Getter
    private volatile int balance;

    public BankAccountV1(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("start withdraw " + getClass().getSimpleName());

        log("request amount: " + amount + " balance: " + balance);
        if (balance < amount) {
            log("amount is invalid");
            return false;
        }
        log("valid amount");
        sleep(1000);
        this.balance = balance - amount;

        log("end withdraw " + getClass().getSimpleName());
        return true;
    }

}
