package com.hoonjin.study.java.start.variable;

public class Var2 {

    public static void main(String[] args) {
        int a; // 변수 선언
        a = 10; // 변수 초기화
        // int a = 10; // 선언과 동시에 초기화 가능

        // 10을 3번 출력하는 요구사항에서 20을 3번 출력하는 요구사항으로 바뀌더라도,
        // a 변수의 값만 바꾸면 된다.
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        // 변수의 값은 반복해서 읽을 수 있다. 변수의 값을 읽는다고 없어지진 않는다.
    }
}
