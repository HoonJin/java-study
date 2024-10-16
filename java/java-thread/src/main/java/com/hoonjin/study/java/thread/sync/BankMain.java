package com.hoonjin.study.java.thread.sync;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccountV1(1000);
        WithdrawTask task = new WithdrawTask(bankAccount, 800);

        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);

        thread.start();
        thread1.start();

        sleep(500);

        thread.join();
        thread1.join();

        log("final balance: " + bankAccount.getBalance());
    }
}
