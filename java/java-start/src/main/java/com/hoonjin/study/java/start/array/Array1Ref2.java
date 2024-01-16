package com.hoonjin.study.java.start.array;

public class Array1Ref2 {

    public static void main(String[] args) {
        int[] students = new int[5];
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        for (int i = 0; i < students.length; i++) {
            //System.out.println("students[" + (i + 1) + "] = " + students[i]);
            // 모든 숫자를 0부터 센다고 생각하면 더 명확하고 간단해진다.
            System.out.println("students[" + i + "] = " + students[i]);
        }
    }

}
