package com.hoonjin.study.java.start.casting;

public class Casting3 {

    public static void main(String[] args) {
        long maxIntValue = Integer.MAX_VALUE;
        long maxIntOver = 2147483648L;

        int intValue = (int) maxIntValue; // int max값 까지는 문제 없음
        System.out.println("intValue(maxIntValue) = " + intValue);

        intValue = (int) maxIntOver; // int max값을 넘어서면 문제가 된다.
        System.out.println("intValue(maxIntOver) = " + intValue);

    }
}
