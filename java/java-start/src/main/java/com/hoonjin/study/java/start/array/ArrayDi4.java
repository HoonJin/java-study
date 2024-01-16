package com.hoonjin.study.java.start.array;

public class ArrayDi4 {

    public static void main(String[] args) {
        // 2 * 3 2차원 어레이
        int[][] arr = new int[4][5];

        int i = 1;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = i++;
            }
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}
