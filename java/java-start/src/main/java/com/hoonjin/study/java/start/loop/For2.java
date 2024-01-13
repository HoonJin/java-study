package com.hoonjin.study.java.start.loop;

public class For2 {

    public static void main(String[] args) {
        int sum = 0;
        int endNum = 3;
        // for (1. 초기식; 2. 조건식; 4. 증감식) {
        //     3. 코드
        // }
        for (int i = 1; i <= endNum /* i < endNum + 1; */; i++) {
            sum += i;
            System.out.println("i = " + i + ", sum = " + sum);
        }
    }
}
