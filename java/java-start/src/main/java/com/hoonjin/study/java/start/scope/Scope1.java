package com.hoonjin.study.java.start.scope;

public class Scope1 {
    public static void main(String[] args) {
        int m = 10;
        if (true) {
            int x = 20;
            System.out.println("if m = " + m);
            System.out.println("if x = " + x);
        }

        System.out.println("main m = " + m);
        // System.out.println("main x = " + x); // 접근할 수 없음, compile error
        // m의 범위도 메인 메서드 불록내 까지이다.
    }
}
