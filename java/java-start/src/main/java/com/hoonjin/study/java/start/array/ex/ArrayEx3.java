package com.hoonjin.study.java.start.array.ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayEx3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[5];

        for (int i = 0; i < nums.length; i++) {
            System.out.print("입력하세요: ");
            nums[i] = scanner.nextInt();
        }

        System.out.println("출력");
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println("nums[" + i + "] = " + nums[i]);
        }

        String collect = Arrays.stream(nums).mapToObj(String::valueOf)
            .collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
