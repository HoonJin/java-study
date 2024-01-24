package com.hoonjin.study.java.basic.ref;

public class NullMain1 {

    public static void main(String[] args) {
        Data data = null;
        System.out.println("1. data = " + data);
        data = new Data();
        System.out.println("2. data = " + data);
        data = null; // 기존에 가리키던 참조값은 더이상 가리키는 변수가 없으면 GC에 의해서 메모리에서 해제된다.
        System.out.println("3. data = " + data);
    }
}
