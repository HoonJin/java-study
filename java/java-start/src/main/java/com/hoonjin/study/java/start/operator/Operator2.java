package com.hoonjin.study.java.start.operator;

public class Operator2 {

    public static void main(String[] args) {
        String result = "Hello " + "world"; // 문자열과 문자열 더하기 -> 문자가 이어진다.
        System.out.println(result);

        String s1 = "string1";
        String s2 = "string2";
        String result2 = s1 + s2; // 문자열 변수와 문자열 변수 더하기
        System.out.println("result2 = " + result2);

        String result3 = "a + b = " + 10; // 문자열 변수와 숫자 등 다른 타입을 더하면 문자열 타입으로 변경하여 더한다
        System.out.println("result3 = " + result3);

        int num = 20;
        String str = "a + b = ";
        String result4 = str + num; // 문자열 변수와 다른 타입 변수를 더하면 문자열 타입으로 변경하여 더한다
        System.out.println(result4);
    }
}
