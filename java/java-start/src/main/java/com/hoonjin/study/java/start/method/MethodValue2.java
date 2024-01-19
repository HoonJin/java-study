package com.hoonjin.study.java.start.method;

public class MethodValue2 {

    public static void main(String[] args) {
        int number = 5;
        System.out.println("1. number = " + number); // 5
        changeNumber(number);
        System.out.println("호출 후 4. number = " + number); // 5
    }

    public static void changeNumber(int number) {
        // changeNumber 메서드 안에서의 number와 main 함수의 number는 다른 변수이다.
        // 이름이 같고 파라미터로 넘겼다고 하든 어쨌든 아예 다른 변수다.
        System.out.println("2. 변경 전 number = " + number); // 5
        number *= 2;
        System.out.println("3. 변경 후 number = " + number); // 10
    }
}
