package com.hoonjin.study.java.start.array;

public class Array1Ref {

    public static void main(String[] args) {
        int[] students = new int[5];

        // array 는 0부터 시작
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        System.out.println("students = " + students); // 배열의 주소값을 가리킴
        // 배열의 위치만 가지고 있다.

        System.out.println("students[0] = " + students[0]);
        System.out.println("students[1] = " + students[1]);
        System.out.println("students[2] = " + students[2]);
        System.out.println("students[3] = " + students[3]);
        System.out.println("students[4] = " + students[4]);

    }
}
