package com.hoonjin.study.java.annotation.basic;

import java.util.Arrays;

public class ElementData1Main {

    public static void main(String[] args) {
        Class<ElementData1> elementData1Class = ElementData1.class;
        AnnoElement annotation = elementData1Class.getAnnotation(AnnoElement.class);

        System.out.println("annotation.value() = " + annotation.value());
        System.out.println("annotation.count() = " + annotation.count());
        System.out.println("annotation.tags() = " + Arrays.toString(annotation.tags()));
    }
}
