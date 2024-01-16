package com.hoonjin.study.java.start.array;

public class Array1Ref3 {

    public static void main(String[] args) {
//        int[] students = new int[]{90, 80, 70, 60, 50};
        int[] students = {90, 80, 70, 60, 50, 30, 20, 10};

        for (int i = 0; i < students.length; i++) {
            //System.out.println("students[" + (i + 1) + "] = " + students[i]);
            // 모든 숫자를 0부터 센다고 생각하면 더 명확하고 간단해진다.
            System.out.println("students[" + i + "] = " + students[i]);
        }
    }

}
