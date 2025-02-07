package com.hoonjin.study.java.interview.array;

import java.util.Arrays;

//1 부터 100 까지의 숫자 중에 50개의 랜덤한 숫자가 들어있는 배열이 있다. 이 배열을 O(n)의 시간 복잡도로 정렬하라.
public class SortByArray {

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 10, 5, 7, 2, 4, 8};
        SortByArray sortByArray = new SortByArray();
        int[] result = sortByArray.solution1(numbers);
        System.out.println("result = " + Arrays.toString(result));
    }

    private int[] solution1(int[] numbers) {
        boolean[] booleans = new boolean[100];
        for (int number : numbers) {
            booleans[number] = true;
        }

        int idx = 0;
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                numbers[idx++] = i;
            }
        }

        return numbers;
    }
}
