package com.hoonjin.study.java.start.array.ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayEx4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            System.out.print("입력하세요: ");
            nums[i] = scanner.nextInt();
        }

        int sum = Arrays.stream(nums).sum();
        double average = (double) sum / nums.length;

        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }
}
