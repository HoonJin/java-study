package com.hoonjin.study.java.start.variable;

public class Var8 {

    public static void main(String[] args) {
        // 정수
        byte b = 127; // -128 ~ 127 // 1byte
        short s = 32767; // -32768 ~ 32767 // 2byte
        int i = 2_147_483_647; // same as Integer.MAX_VALUE // -2_147_483_648 ~ 2_147_483_647 (약 21억) // 4byte
        //int i1 = 2_147_483_648; // overflow로 compile error 발생
        long l = 9_223_372_036_854_775_807L; // same as Long.MAX_VALUE // -9223372036854775808 ~ 9223372036854775807 // 8byte

        // 실수
        float f = 10.1f; // 정밀도 7자리
        double d = 10.2; // 정밀도 15자리

        //
        // short -> 용량이 작고 기본 연산을 int 를 사용하기 떄문에 거의 사용하지 않는다.
        // byte -> short 와 같이 거의 사용하지 않으나 파일을 바이트 단위로 다룰 때만 사용한다.
        // float -> 정밀도가 너무 낮아 double만 사용한다
        // char -> String 이 효율적이라 스트링을 사용한다
        // 메모리 용량이 메모리 저렴해져서 개발 속도와 효율성을 더 중시한다.
    }
}
