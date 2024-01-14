package com.hoonjin.study.java.start.casting;

public class Casting1 {

    public static void main(String[] args) {
        int intValue = 10;
        long longValue;
        double doubleValue;

        // 작은 범위의 값 타입에서 큰 범위의 타입으로 캐스팅시 자동으로 형변환한다.
        longValue = intValue; // int -> long
        System.out.println("longValue = " + longValue);
        //intValue = longValue; // compile error 실행할 수 없는 코드;

        doubleValue = intValue; // int -> double
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L; // long -> double
        System.out.println("doubleValue = " + doubleValue);
    }
}
