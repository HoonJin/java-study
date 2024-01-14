package com.hoonjin.study.java.start.casting;

public class Casting4 {

    public static void main(String[] args) {
        int div1 = 3 / 2; // 1, 1.5X <- 3 / 2
        System.out.println("div1 = " + div1);

        double div2 = 3 / 2; // 1.0, 1.5X <- (double) (3 / 2) // 소수점 유실 상태로 형변환 일어남
        System.out.println("div2 = " + div2);

        double div3 = 3.0 / 2; // 3.0 / 2.0
        System.out.println("div3 = " + div3);

        double div4 = (double) 3 / 2;  // 3.0 / 2.0
        System.out.println("div4 = " + div4);

        int a = 3;
        int b = 2;
        double result = (double) a / b;
        System.out.println("result = " + result);
    }
}
