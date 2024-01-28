package com.hoonjin.study.java.basic.construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age, int grade) {
        System.out.println("constructor is called");
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    MemberConstruct(String name, int age) {
        this(name, age, 50);
        // 생성자에 중복 코드를 피하기 위하여 this() 호출로 생성자 호출
        //this.name = name;
        //this.age = age;
        //this.grade = 50;
    }
}
