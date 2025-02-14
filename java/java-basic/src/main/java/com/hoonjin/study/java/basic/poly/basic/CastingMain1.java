package com.hoonjin.study.java.basic.poly.basic;

public class CastingMain1 {

    public static void main(String[] args) {
        // 다형적 참조
        Parent poly = new Child(); // x001

        // 다운 캐스팅 (부모 타입 -> 자식 타입)
        Child child = (Child) poly; // x001 -> 주소값이 같다
        child.childMethod();

    }
}
