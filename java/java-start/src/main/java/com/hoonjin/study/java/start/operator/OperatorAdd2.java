package com.hoonjin.study.java.start.operator;

public class OperatorAdd2 {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        // 전위 증감 연산자
        b = ++a; // a 값을 증가시키고 b 에 대입
        // a = a + 1
        // b = a
        System.out.println("a = " + a + ", b = " + b);

        // 후위 증감 연산자
        b = a++; // a를 b에 할당하고 a값 증가
        // b = a
        // a = a + 1
        System.out.println("a = " + a + ", b = " + b);

        // 두 줄을 한줄로 처리한다고 보면 된다.
        // 증감 연산자를 단독으로만 쓰면 혼동없이 쓸 수 있다.
        ++a;
        System.out.println("a = " + a); // 1 더해진 값을 얻음
        ++a;
        System.out.println("a = " + a); // 1 더해진 값을 얻음
    }
}
