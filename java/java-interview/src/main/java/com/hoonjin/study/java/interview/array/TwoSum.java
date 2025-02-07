package com.hoonjin.study.java.interview.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는 두 수를 더해 target 숫자를 만들 수 있는 인덱스 두개를 찾는 함수를 작성하라.
//
//예) numbers = [2, 3, 5, 7] target = 8, 8을 만들 수 있는 3과 5의 인덱스인 1, 2를 리턴해야 한다.
//예) numbers = [1, 2, 6, 8] target = 9, 9를 만들 수 있는 1과 8의 인덱스인 0, 3을 리턴해야 한다.
//
//numbers 배열에 중복되는 숫자는 없으며 target 숫자를 만들 수 있는 조합은 하나 뿐이라고 가정해도 좋다.
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 5, 7};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.solution2(numbers, target);
        System.out.println("result = " + Arrays.toString(result));
    }

    // 시간 복잡도 N^2, 공간 복잡도 1
    private int[] solution1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    // 시간 복잡도 N, 공간 복잡도 N
    private int[] solution2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int numberToFind = target - number;
            if (map.containsKey(numberToFind) && map.get(numberToFind) != i) {
                return new int[]{i, map.get(numberToFind)};
            } else {
                map.put(numbers[i], i);
            }
        }

        return null;
    }


}
