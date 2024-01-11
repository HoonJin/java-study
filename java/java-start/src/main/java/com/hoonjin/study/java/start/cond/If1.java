package com.hoonjin.study.java.start.cond;

public class If1 {

    public static void main(String[] args) {
        int age = 20;

        // if 특정 조건이 성립할 때만 특정 블록을 실행한다.
        if (age >= 18) {
            System.out.println("성인입니다.");
        }

        if (age < 18) {
            System.out.println("미성년자입니다.");
        }
    }
}
