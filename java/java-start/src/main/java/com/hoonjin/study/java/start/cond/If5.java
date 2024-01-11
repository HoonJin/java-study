package com.hoonjin.study.java.start.cond;

public class If5 {

    public static void main(String[] args) {
        int price = 10000;
        int age = 10;
        int discount = 0;

        if (price >= 10000) {
            discount += 1000;
            System.out.println("만원이상 구매 1000원 할인 ");
        }

        if (age <= 10) {
            discount += 1000;
            System.out.println("어린이 할인 1000원");
        }

        System.out.println("discount = " + discount);

        if (false)
            System.out.println("if (false) 내에서 실행되지 않음");
            System.out.println("이 잘못된 컨벤션은 if 구문과 상관없이 내에서 실행 되는가?");
    }
}
