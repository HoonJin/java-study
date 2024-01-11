package com.hoonjin.study.java.start.cond;

public class If6 {

    public static void main(String[] args) {
        int price = 10000;
        int age = 10;
        int discount = 0;

        // 버그가 있다. if 절이 성립했을 때 if else 를 보지 않음.
        if (price >= 10000) {
            discount += 1000;
            System.out.println("만원이상 구매 1000원 할인 ");
        } else if (age <= 10) {
            discount += 1000;
            System.out.println("어린이 할인 1000원");
        } else {
            System.out.println("할인 없음");
        }

        System.out.println("discount = " + discount);
    }
}
