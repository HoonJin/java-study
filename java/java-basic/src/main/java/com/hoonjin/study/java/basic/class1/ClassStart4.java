package com.hoonjin.study.java.basic.class1;

public class ClassStart4 {

    public static void main(String[] args) {
        Student student1;
        student1 = new Student();
        student1.name = "이름1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "이름2";
        student2.age = 16;
        student2.grade = 80;

        Student[] students = new Student[2];
        students[0] = student1;
        students[1] = student2;

        System.out.println("이름: " + students[0].name + ", 나이: " + students[0].age + ", 성적: = " + students[0].grade);
        System.out.println("이름: " + students[1].name + ", 나이: " + students[1].age + ", 성적: = " + students[1].grade);
        // 자바에서 대입은 항상 변수에 들어있는 값을 복사해서 전달한다.
        // 배열내의 요소(students[1])는 참조값(students2)을 가리키고
        // 그 참조값이 객체의 참조값(name, age, grade)을 가리키는 구조
        // 그대로 유지되기 때문에 students2값을 변경하면 배열내 요소값도 변경된다.
        student2.name = "바꾸기";
        System.out.println("이름: " + students[1].name + ", 나이: " + students[1].age + ", 성적: = " + students[1].grade);

    }
}
