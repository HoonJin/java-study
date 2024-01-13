package com.hoonjin.study.java.start.loop.ex;

public class WhileEx2 {

    public static void main(String[] args) {
        int num = 2;
        int count = 0;
        while (count < 10) {
            System.out.println("num = " + num);
            num += 2;
            count++;
        }
    }
}
