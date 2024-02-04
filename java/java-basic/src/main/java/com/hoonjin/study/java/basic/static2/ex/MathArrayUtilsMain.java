package com.hoonjin.study.java.basic.static2.ex;

public class MathArrayUtilsMain {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        System.out.println("sum(values) = " + MathArrayUtils.sum(values));
        System.out.println("average(values) = " + MathArrayUtils.average(values));
        System.out.println("min(values) = " + MathArrayUtils.min(values));
        System.out.println("max(values) = " + MathArrayUtils.max(values));
    }
}
