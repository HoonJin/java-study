package com.hoonjin.study.java.thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class MyPrinterV2 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer);
        printerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("문서를 입력하세요. 종료 (q): ");
            String input = scanner.nextLine();

            if(input.equals("q")) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }
        log("quit");
    }

    static class Printer implements Runnable {
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (queue.isEmpty()) {
                    continue;
                }

                try {
                    String job = queue.poll();
                    log("start job: " + job + ", waiting jobs: " + queue);
                    Thread.sleep(3000);
                    log("job " + job + " is completed");
                } catch (InterruptedException e) {
                    log("interrupted");
                    break;
                }
            }
        }

        public void addJob(String input) {
            queue.offer(input);
        }
    }
}
