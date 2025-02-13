package com.hoonjin.study.java.interview.stack;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//주어진 수식의 괄호짝이 맞는지 확인하는 코드를 작성하라.
//
//예) [{1 + 2 * (2 + 2)} - (1 - 3)]   => true
//예) [{1 + 2 * (2 + 2)} - [1 - 3)]   => false
public class CheckingBrackets {

    public static void main(String[] args) {
        CheckingBrackets checkingBrackets = new CheckingBrackets();
        System.out.println(checkingBrackets.check("( 1 + 2 ) * 3"));
        System.out.println(checkingBrackets.check("{()}"));
        System.out.println(checkingBrackets.check("[{()}"));
        System.out.println(checkingBrackets.check("[{()}]"));
        System.out.println(checkingBrackets.check("{()}]"));

    }

    private boolean check(String mathExpression) {
        Stack<Character> brackets = new Stack<>();
        List<Character> openingBrackets = Arrays.asList('[', '{', '(');
        List<Character> closingBrackets = Arrays.asList(']', '}', ')');

        for (char c : mathExpression.toCharArray()) {
            if (openingBrackets.contains(c)) {
                brackets.push(c);
            } else if (closingBrackets.contains(c)) {
                if (brackets.empty()) {
                    return false;
                }

                Character opening = brackets.pop();
                if (closingBrackets.indexOf(c) != openingBrackets.indexOf(opening)) {
                    return false;
                }
            }
        }
        return brackets.empty();
    }
}
