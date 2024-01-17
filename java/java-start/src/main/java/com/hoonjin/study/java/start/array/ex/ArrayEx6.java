package com.hoonjin.study.java.start.array.ex;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class ArrayEx6 {

    public static void main(String[] args) {
        System.out.print("숫자의 개수를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];

        for (int i = 0; i < nums.length; i++) {
            System.out.print((i + 1) + "번째 입력하세요: ");
            nums[i] = scanner.nextInt();
        }

        int maxNum = nums[0];
        int minNum = nums[0];

        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
            if (num < minNum) {
                minNum = num;
            }
        }
        System.out.println("maxNum = " + maxNum);
        System.out.println("minNum = " + minNum);

        int max = Arrays.stream(nums).max().orElse(0);
        int min = Arrays.stream(nums).min().orElse(0);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
