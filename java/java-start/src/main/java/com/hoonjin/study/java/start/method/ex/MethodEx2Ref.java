package com.hoonjin.study.java.start.method.ex;

public class MethodEx2Ref {

    public static void main(String[] args) {
        String message = "hello world!";
        printMessage(message, 3);
        printMessage("java", 5);
        printMessage("HI", 7);
    }

    public static void printMessage(String message, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(message);
        }
    }
}
