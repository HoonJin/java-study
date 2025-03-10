package com.hoonjin.study.java.thread.sync;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount {

    private int balance; // volatile 없어도 된다

    public BankAccountV3(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("start withdraw " + getClass().getSimpleName());

        synchronized(this) {
            log("request amount: " + amount + " balance: " + balance);
            if (balance < amount) {
                log("amount is invalid");
                return false;
            }
            log("valid amount");
            sleep(1000);
            this.balance = balance - amount;
        }

        log("end withdraw " + getClass().getSimpleName());
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
