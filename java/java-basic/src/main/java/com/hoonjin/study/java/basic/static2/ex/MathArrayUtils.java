package com.hoonjin.study.java.basic.static2.ex;

import java.util.Arrays;

public class MathArrayUtils {

    private MathArrayUtils() {
    }

    public static int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    public static int average(int[] nums) {
        return (int) Arrays.stream(nums).average().orElse(0.0);
    }

    public static int min(int[] nums) {
        return Arrays.stream(nums).min().orElse(0);
    }

    public static int max(int[] nums) {
        return Arrays.stream(nums).max().orElse(0);
    }
}
