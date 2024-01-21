package com.hoonjin.study.java.basic.class1;

public class ClassStart2 {

    public static void main(String[] args) {
        String[] stuNames = {"이름1", "이름2"};
        int[] stuAges = {15, 16};
        int[] stuGrades = {90, 80};

        for (int i = 0; i < stuNames.length; i++) {
            System.out.println("이름: " + stuNames[i] + ", 나이: " + stuAges[i] + ", 성적: = " + stuGrades[i]);
        }

    }
}
