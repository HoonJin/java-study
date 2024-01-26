package com.hoonjin.study.java.basic.oop1;

public class ValueDataMain {

    public static void main(String[] args) {
        ValueData data = new ValueData();
        add(data);
        add(data);
        add(data);
        System.out.println("final data.value = " + data.value);
    }

    static void add(ValueData data) {
        data.value++;
        System.out.println("data.value = " + data.value);
    }
}
