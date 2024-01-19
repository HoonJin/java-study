package com.hoonjin.study.java.start.method;

public class MethodReturn2 {

    public static void main(String[] args) {
        int age = 24;
        checkAge(age);
    }

    public static boolean checkAge(int age) {
        if (age < 18) {
            System.out.println("미성년자 불가");
            return false;
        } else {
            System.out.println("성년 가능");
            return true;
        }
    }
}
