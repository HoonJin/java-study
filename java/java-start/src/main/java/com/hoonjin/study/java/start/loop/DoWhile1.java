package com.hoonjin.study.java.start.loop;

public class DoWhile1 {

    public static void main(String[] args) {
        int i = 10;

        // 조건이 성립하지 않아 while 문에 들어가지 않는다.
        while (i < 3) {
            System.out.println("i = " + i);
            i++;
        }
    }
}
