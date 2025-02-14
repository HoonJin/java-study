package com.hoonjin.study.java.basic.poly.basic;

public class PolyMain {

    public static void main(String[] args) {
        // 부모 변수가 부모 인스턴스 참조
        System.out.println("parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();

        // 자식 변수가 자식 인스턴스 참조
        System.out.println("child -> Child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();

        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("parent -> Child");
        Parent poly = new Child();
        poly.parentMethod();

        // 자식의 기능 호출 불가. 컴파일 오류 발생
//        poly.childMethod(); Parent 타입은 Child 타입의 메서드를 알 수 없다.
    }
}
