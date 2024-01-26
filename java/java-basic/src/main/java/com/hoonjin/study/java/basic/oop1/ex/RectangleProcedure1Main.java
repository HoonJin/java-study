package com.hoonjin.study.java.basic.oop1.ex;

public class RectangleProcedure1Main {

    public static void main(String[] args) {
        int width = 5;
        int height = 8;

        int area = calculateArea(width, height);
        System.out.println("area = " + area);

        int perimeter = calculatePerimeter(width, height);
        System.out.println("perimeter = " + perimeter);

        boolean square = isSquare(width, height);
        System.out.println("square = " + square);
    }

    private static boolean isSquare(int width, int height) {
        return width == height;
    }

    private static int calculateArea(int width, int height) {
        return width * height;
    }

    private static int calculatePerimeter(int width, int height) {
        return (width + height) * 2;
    }
}
