package com.hoonjin.study.java.basic.final1;

public class FinalFieldMain {

    public static void main(String[] args) {

        System.out.println("final field - init by constructor");
        ConstructInit init1 = new ConstructInit(10);
        ConstructInit init2 = new ConstructInit(20);
        System.out.println("init1.value = " + init1.value);
        System.out.println("init2.value = " + init2.value);

        System.out.println("final field - init by assign");
        FieldInit fieldInit1 = new FieldInit();
        FieldInit fieldInit2 = new FieldInit();
        FieldInit fieldInit3 = new FieldInit();
        System.out.println("fieldInit1.value = " + fieldInit1.value);
        System.out.println("fieldInit2.value = " + fieldInit2.value);
        System.out.println("fieldInit3.value = " + fieldInit3.value);

        System.out.println("CONST VARIABLE");
        System.out.println("FieldInit.CONST_VALUE = " + FieldInit.CONST_VALUE);
    }
}
