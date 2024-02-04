package com.hoonjin.study.java.basic.final1;

public class FinalLocalMain {

    public static void main(String[] args) {
        // final 지역 변수
        final int data1;
        data1 = 10; // 최초 할당만 가능
        //data1 = 20; // complie error

        // final 지역 변수
        final int data2 = 20;
        //data2 = 30; // complie error
    }

    static void method(final int param) {
        //param *= 2; compile error
    }
}
