package com.hoonjin.study.java.basic.static2;

import static com.hoonjin.study.java.basic.static2.DecoData.staticCall;

public class ValueDataMain {

    public static void main(String[] args) {
        System.out.println("static call");
        DecoData.staticCall();
        staticCall();
        staticCall();
        staticCall();
    }
}
