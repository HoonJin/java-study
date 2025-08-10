package com.hoonjin.study.java.methodref;

import java.util.function.BiFunction;

public class MethodRefEx6 {

    public static void main(String[] args) {
        // 4. 임의 객체의 인스턴스 메서드 참조 (특정 타입의)
        Person person = new Person("Kim");

        BiFunction<Person, Integer, String> fun1 = (p, n) -> p.introduceWithNumber(n);
        System.out.println("fun1.apply(person, 1) = " + fun1.apply(person, 1));

        // 메서드 참조, 타입이 첫번째 매개변수가 됨
        // 그리고 첫번째 매개변수의 메서드 호출
        // 나머지는 순서대로 매개변수에 전달
        BiFunction<Person, Integer, String> fun2 = Person::introduceWithNumber;
        System.out.println("fun2.apply(person, 2) = " + fun2.apply(person, 2));
    }
}
