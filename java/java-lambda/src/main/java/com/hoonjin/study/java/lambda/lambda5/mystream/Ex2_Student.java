package com.hoonjin.study.java.lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;

import static com.hoonjin.study.java.lambda.lambda5.filter.GenericFilter.filter;
import static com.hoonjin.study.java.lambda.lambda5.map.GenericMapper.map;

public class Ex2_Student {

    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Apple", 100),
            new Student("Banana", 80),
            new Student("Choco", 50),
            new Student("D", 40)
        );

        // 80점 이상인 학생의 이름을 반환
        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    private static List<String> lambda(List<Student> students) {
        return map(filter(students, i -> i.getScore() > 80), i -> i.getName());
    }

    public static List<String> direct(List<Student> students) {
        List<String> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() > 80) { // 짝수만 필터링
                result.add(student.getName());
            }
        }
        return result;
    }
}
