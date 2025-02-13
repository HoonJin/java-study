package com.hoonjin.study.java.interview.stack;

import java.util.Arrays;
import java.util.LinkedList;

//주어진 배열 prices에 대한 스팬을 구하는 코드를 작성하라.
//스팬: 당일의 주가 보다 낮거나 같았던 연속적인 일 수.
//
//예) [5, 3, 2, 4, 7, 1]    =>   [1, 1, 1, 3, 5, 1]
//예) [2, 3, 4, 5, 6, 7]    =>   [1, 2, 3, 4, 5, 6]
public class FindSpan {

    public static void main(String[] args) {
        FindSpan findSpan = new FindSpan();
        System.out.println(Arrays.toString(findSpan.solution(new int[]{5, 3, 2, 4, 7, 1})));
        System.out.println(Arrays.toString(findSpan.solution(new int[]{2, 3, 4, 5, 6, 7})));
    }

    private int[] solution(int[] prices) {
        int[] span = new int[prices.length];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] < prices[i]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }
}
