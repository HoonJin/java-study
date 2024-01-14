package com.hoonjin.study.java.start.scope;

public class Scope2 {
    public static void main(String[] args) {
        int m = 10;
        for (int i = 0; i < 2; i++) {
            System.out.println("for m = " + m);
            System.out.println("for i = " + i);
        } // 이 블록 내에서만 i 사용 가능
//        System.out.println("main i = " + i); 스코프가 끝나서 접근 불가
        System.out.println("main m = " + m);
    }
}
