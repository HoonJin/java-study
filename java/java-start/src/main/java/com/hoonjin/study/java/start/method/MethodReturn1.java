package com.hoonjin.study.java.start.method;

public class MethodReturn1 {

    public static void main(String[] args) {

    }

    public static boolean odd(int i) {
        return i % 2 == 1; // if 문 만들고 else 절 넣지 않으면 컴파일 에러
        // 반환 타입이 있으면 반드시 반환을 하면서 끝나야 한다.
    }
}
