package com.hoonjin.study.java.interview.array;

import java.util.Arrays;

//주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
//
//예) hello => olleh
//예) happy new year => reay wen yppah
public class ReverseCharacter {

    public static void main(String[] args) {
        char[] input = "Hello".toCharArray();
        ReverseCharacter reverseCharacter = new ReverseCharacter();
        char[] result = reverseCharacter.solution2(input);
        System.out.println("result = " + Arrays.toString(result));
    }

    // 시간 복잡도 N, 공간 복잡도 N
    private char[] solution1(char[] message) {
        char[] reversed = new char[message.length];
        for (int i = message.length - 1; i >= 0; i--) {
            reversed[message.length - 1 - i] = message[i];
        }

        return reversed;
    }

    // 시간 복잡도 N, 공간 복잡도 1
    private char[] solution2(char[] message) {
        for (int i = 0; i < message.length / 2; i++) {
            char temp = message[i];
            message[i] = message[message.length - 1 - i];
            message[message.length - 1 - i] = temp;
        }

        return message;
    }
}
