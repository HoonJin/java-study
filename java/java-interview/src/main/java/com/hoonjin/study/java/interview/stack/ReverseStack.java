package com.hoonjin.study.java.interview.stack;

import java.util.Stack;

//스택을 뒤집는 코드를 작성하라.
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);
        numbers.push(4);

        System.out.println("numbers = " + numbers);

        ReverseStack reverseStack = new ReverseStack();
//        Stack<Integer> reversed = reverseStack.solution1(numbers);
//        System.out.println("reversed = " + reversed);
        reverseStack.solution2(numbers);
        System.out.println("numbers = " + numbers);

    }

    // 시간 복잡도 N^2, 공간 복잡도 1
    private void solution2(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        solution2(stack);
        insertAtBottom(stack, temp);
    }

    private void insertAtBottom(Stack<Integer> stack, int number) {
        if (stack.empty()) {
            stack.push(number);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, number);
            stack.push(temp);
        }
    }

    // 시간 복잡도 N, 공간 복잡도 N
    private Stack<Integer> solution1(Stack<Integer> stack) {
        Stack<Integer> reversedStack = pnew Stack<>();
        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }
        return reversedStack;
    }
}
