package com.hoonjin.study.java.start.array;

public class EnhancedFor1 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[i] = " + numbers[i]);
        }

        for (int num : numbers) {
            System.out.println("num = " + num);
        }
    }
}
