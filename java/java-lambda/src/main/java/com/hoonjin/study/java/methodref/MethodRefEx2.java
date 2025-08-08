package com.hoonjin.study.java.methodref;

import java.util.function.Function;

public class MethodRefEx2 {

    public static void main(String[] args) {
        // 1. 정적 메서드 참조
        Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);
        Function<String, String> staticMethod2 = Person::greetingWithName;

        System.out.println("staticMethod1.apply() = " + staticMethod1.apply("Kim"));
        System.out.println("staticMethod2.apply() = " + staticMethod2.apply("Kim"));

        // 2. 특정 객체의 인스턴스 참조
        Person person = new Person("Kim");
        Function<Integer, String> instanceMethod1 = num -> person.introduceWithNumber(num);
        Function<Integer, String> instanceMethod2 = person::introduceWithNumber;

        System.out.println("instanceMethod1.apply() = " + instanceMethod1.apply(5));
        System.out.println("instanceMethod2.apply() = " + instanceMethod2.apply(5));

        // 3. 생성자 참조
        Function<String, Person> constructor1 = name -> new Person(name);
        Function<String, Person> constructor2 = Person::new; // 타입 추론으로 적합한 생성자를 찾는다.

        System.out.println("constructor1.apply() = " + constructor1.apply("Lee"));
        System.out.println("constructor2.apply() = " + constructor2.apply("Lee"));

    }
}
