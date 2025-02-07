package com.hoonjin.study.java.interview.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는지 확인하는 함수를 작성하라. 중복된 숫자가 있다면 true 없다면 false.
//
//예) 1 2 3 4 5 6 => false
//예) 1 1 2 2 3 1 => true
public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] ints = {1, 2, 3, 4, 5, 6, 1};
        boolean result = containsDuplicate.solution3(ints);
        System.out.println("result = " + result);
    }

    // 시간 복잡도 N^2, 공간 복잡도 1
    private boolean solution1(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // 시간 복잡도 N * logN, 공간 복잡도 logN
    private boolean solution2(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return true;
            }
        }

        return false;
    }

    // 시간 복잡도 N, 공간 복잡도 N
    private boolean solution3(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return true;
            } else {
                set.add(number);
            }
        }
        return false;
    }
}
