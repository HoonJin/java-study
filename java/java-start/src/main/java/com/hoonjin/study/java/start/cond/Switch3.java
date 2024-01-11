package com.hoonjin.study.java.start.cond;

public class Switch3 {

    public static void main(String[] args) {
        int grade = 2;

        int coupon;
        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:
            case 3:
//            case 2, 3:
                coupon = 3000;
                break;
            default:
                coupon = 0;
        }
        // int coupon = switch (grade) {
        //   case 1 -> 1000;
        //   case 2, 3 -> 3000;
        //   default -> 0;
        // };

        System.out.println("coupon = " + coupon);
    }
}
