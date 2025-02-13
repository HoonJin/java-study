package com.hoonjin.study.java.interview.stack;

import java.util.LinkedList;

//인픽스를 포스트픽스로 변환하기
public class InfixToPostfix {

    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        System.out.println(infixToPostfix.convert("1+2*3"));
        System.out.println(infixToPostfix.convert("(1+2)*3"));
    }

    private int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    private String convert(String expression) {
        char[] chars = expression.trim().toCharArray();
        StringBuilder postfix = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : chars) {

            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
}
