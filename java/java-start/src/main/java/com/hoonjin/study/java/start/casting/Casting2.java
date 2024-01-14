package com.hoonjin.study.java.start.casting;

public class Casting2 {

    public static void main(String[] args) {
        double doubleValue = 1.5;
        int intValue = 0;

        //intValue = doubleValue; // compile error
        intValue = (int) doubleValue; // 강제 형 변환 소수점이 유실됨
        System.out.println("intValue = " + intValue);
        // 이전값은 바뀌지 않는다
        System.out.println("doubleValue = " + doubleValue);
    }
}
