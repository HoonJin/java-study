package com.hoonjin.study.java.start.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx5 {

    public static void main(String[] args) {
        System.out.print("숫자의 개수를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];

        for (int i = 0; i < nums.length; i++) {
            System.out.print((i + 1) + "번째 입력하세요: ");
            nums[i] = scanner.nextInt();
        }

        int sum = Arrays.stream(nums).sum();
        double average = (double) sum / nums.length;

        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }
}
