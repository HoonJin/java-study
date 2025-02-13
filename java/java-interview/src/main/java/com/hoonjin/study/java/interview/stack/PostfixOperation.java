package com.hoonjin.study.java.interview.stack;

import java.util.LinkedList;

//포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+, -, *, /)만 사용한다고 가정한다.
//
//예) 12+         => 3
//예) 123+-5*  => -20
public class PostfixOperation {

    public static void main(String[] args) {
        PostfixOperation postfixOperation = new PostfixOperation();
        System.out.println(postfixOperation.evaluate("52+") == 7);
        System.out.println(postfixOperation.evaluate("52-") == 3);
        System.out.println(postfixOperation.evaluate("52*") == 10);
        System.out.println(postfixOperation.evaluate("42/") == 2);
    }

    private int evaluate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();

        char[] chars = s.trim().toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
//                stack.push(Integer.parseInt(c + ""));
                stack.push(c - '0');
            } else {
                int right = stack.pop();
                int left = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        stack.push(left / right);
                        break;

                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException();
        }

        return stack.pop();
    }
}
