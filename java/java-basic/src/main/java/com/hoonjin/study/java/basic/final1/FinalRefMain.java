package com.hoonjin.study.java.basic.final1;

import lombok.val;

public class FinalRefMain {

    public static void main(String[] args) {
        final Data data = new Data();
        //data = new Date(); // 변경 불가능
        //data.value = 20; //참조 대상의 값은 값은 변경가능
        //data = null; // 불가능

        data.value = 1000;
        System.out.println("data.value = " + data.value);
        data.value = 2000;
        System.out.println("data.value = " + data.value);

    }
}
