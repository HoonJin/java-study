package com.hoonjin.study.java.start.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] scores = new int[4][3];

        String[] subjects = {"국어", "영어", "수학"};
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + "번 학생의 성적을 입력하세요: ");
            for (int j = 0; j < subjects.length; j++) {
                System.out.print(subjects[j] + " 점수: ");
                scores[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < scores.length; i++) {
            int total = Arrays.stream(scores[i]).sum();
            double average = Arrays.stream(scores[i]).average().orElse(0);

            System.out.println(i + "번째 학생의 총점 = " + total);
            System.out.println(i + "번째 학생의 평균 = " + average);
        }
    }
}
