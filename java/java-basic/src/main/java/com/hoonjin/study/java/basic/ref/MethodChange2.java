package com.hoonjin.study.java.basic.ref;

public class MethodChange2 {

    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;

        System.out.println("before call method dataA.value = " + dataA.value); // 10
        changeReference(dataA);
        System.out.println("after call method dataA.value = " + dataA.value); // 20
    }

    private static void changeReference(Data data) {
        data.value = 20;
    }
}
