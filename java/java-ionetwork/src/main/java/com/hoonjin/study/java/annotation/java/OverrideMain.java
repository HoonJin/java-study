package com.hoonjin.study.java.annotation.java;

public class OverrideMain {

    static class A {
        public void call() {
            System.out.println("A.call()");
        }
    }

    static class B extends A {
//        @Override // 주석을 풀면 컴파일 오류
        // 재 정의가 아닌 새 메서드 정의
        public void callll() {
            System.out.println("B.call()");
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.call();
    }
}
