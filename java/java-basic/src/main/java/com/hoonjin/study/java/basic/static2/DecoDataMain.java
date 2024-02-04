package com.hoonjin.study.java.basic.static2;

public class DecoDataMain {

    public static void main(String[] args) {
        System.out.println("1. static call");
        DecoData.staticCall();

        System.out.println("2. instance call");
        DecoData decoData = new DecoData();
        decoData.instanceCall();

        System.out.println("3. instance call");
        DecoData data = new DecoData();
        data.instanceCall();

        DecoData.staticMethod();
    }
}
