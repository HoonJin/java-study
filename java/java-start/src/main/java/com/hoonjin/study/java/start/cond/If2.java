package com.hoonjin.study.java.start.cond;

public class If2 {

    public static void main(String[] args) {
        int age = 10;

        // if 특정 조건이 성립할 때만 특정 블록을 실행한다.
        if (age >= 18) {
            System.out.println("성인입니다.");
        } else { // if, else if 조건에 만족하지 않을때 실행
            System.out.println("미성년자입니다.");
        }
    }
}
