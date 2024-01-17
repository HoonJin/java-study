package com.hoonjin.study.java.start.array.ex;

import java.util.Arrays;

public class ArrayEx1Ref {

    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};

        int sum = Arrays.stream(students).sum();
        int average = sum / students.length;

        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }
}
