package com.hoonjin.study.java.start.loop;

public class DoWhile2 {

    public static void main(String[] args) {
        int i = 10;

        // 일단 블록을 한번 실행하고 조건을 비교한다.
        do {
            System.out.println("i = " + i);
            i++;
        } while (i < 3);
    }
}
