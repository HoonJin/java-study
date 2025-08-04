package com.hoonjin.study.java.lambda.ex1;

import com.hoonjin.study.java.lambda.MyFunction;

public class M5Return {

    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            default:
                return (a, b) -> 0;
        }
    }

    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        System.out.println("add.apply(1, 2) = " + add.apply(1, 2));

        MyFunction sub = getOperation("sub");
        System.out.println("sub.apply(1, 2) = " + sub.apply(1, 2));

        MyFunction xxx = getOperation("xxx");
        System.out.println("xxx.apply(1, 2) = " + xxx.apply(1, 2));
    }
}
