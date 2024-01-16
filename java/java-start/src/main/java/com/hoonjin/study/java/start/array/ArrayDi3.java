package com.hoonjin.study.java.start.array;

public class ArrayDi3 {

    public static void main(String[] args) {
        // 2 * 3 2차원 어레이
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}
