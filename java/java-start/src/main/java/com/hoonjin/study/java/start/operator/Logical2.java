package com.hoonjin.study.java.start.operator;

public class Logical2 {

    public static void main(String[] args) {
        int a = 15;

        // a는 10보다 크고 20보다 작다
        boolean result = a > 10 && a < 20; //(a > 10) && (a < 20)
        //boolean result = 10 < a && a < 20; // 윗줄과 같은데 읽기가 조금더 쉽다.
        System.out.println("result = " + result);


    }
}
