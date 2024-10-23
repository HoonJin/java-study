package com.hoonjin.study.java.thread.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class BankAccountV6 implements BankAccount {

    private int balance; // volatile 없어도 된다
    private final Lock lock = new ReentrantLock();

    public BankAccountV6(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("start withdraw " + getClass().getSimpleName());

        try {
            if (!lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
                log("already in progress");
                return false;
            }
        } catch (InterruptedException e) {
            log("failed to lock");
            return false;
        }

        try {
            log("request amount: " + amount + " balance: " + balance);
            if (balance < amount) {
                log("amount is invalid");
                return false;
            }
            log("valid amount");
            sleep(1000);
            this.balance = balance - amount;
        } finally {
            lock.unlock();
        }

        log("end withdraw " + getClass().getSimpleName());
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}