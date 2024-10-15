package com.hoonjin.study.java.thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer);
        printerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("문서를 입력하세요. 종료 (q): ");
            String input = scanner.nextLine();

            if(input.equals("q")) {
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }
        log("quit");
    }

    static class Printer implements Runnable {
        volatile boolean work = true;
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (work) {
                if (queue.isEmpty()) {
                    continue;
                }

                String job = queue.poll();
                log("start job: " + job + " waiting jobs: " + queue);
                sleep(3000);
                log("job " + job + " is completed");
            }
        }

        public void addJob(String input) {
            queue.offer(input);
        }
    }
}
