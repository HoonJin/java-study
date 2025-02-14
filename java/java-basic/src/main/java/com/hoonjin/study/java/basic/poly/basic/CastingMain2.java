package com.hoonjin.study.java.basic.poly.basic;

public class CastingMain2 {

    public static void main(String[] args) {
        // 다형적 참조
        Parent poly = new Child(); // x001
        // poly.childMethod(); // 컴파일 에러

        // 다운 캐스팅 (부모 타입 -> 자식 타입)
        ((Child) poly).childMethod();

    }
}
