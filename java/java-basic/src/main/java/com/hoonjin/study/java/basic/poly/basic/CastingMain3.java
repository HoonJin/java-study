package com.hoonjin.study.java.basic.poly.basic;

public class CastingMain3 {

    // upcasting vs downcasting
    public static void main(String[] args) {
        // 다형적 참조
        Child child = new Child(); // x001
        Parent parent1 = (Parent) child;
        Parent parent2 = child; // 업 캐스팅은 타입 변경 생략 가능, 권장

        parent1.parentMethod();
        parent2.parentMethod();

    }
}
