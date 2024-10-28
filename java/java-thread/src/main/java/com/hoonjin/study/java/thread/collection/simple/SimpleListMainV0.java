package com.hoonjin.study.java.thread.collection.simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleListMainV0 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("A"); // thread A 실행 가정
        list.add("B"); // thread B 실행 가정
        System.out.println("list = " + list); // 순서를 보장할수 없게 됨
    }
}
