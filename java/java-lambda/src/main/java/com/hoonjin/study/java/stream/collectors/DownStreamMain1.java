package com.hoonjin.study.java.stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class DownStreamMain1 {

    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Alice", 1, 85),
            new Student("Bob", 1, 70),
            new Student("Charlie", 2, 70),
            new Student("David", 2, 90),
            new Student("Eve", 3, 90),
            new Student("Frank", 3, 89)
        );

        // 1. 학년별로 학생들을 그룹화
        Map<Integer, List<Student>> collect1_1 = students.stream()
            .collect(groupingBy(
                Student::getGrade,
                Collectors.toList()
            ));
        System.out.println("collect1_1 = " + collect1_1);

        Map<Integer, List<Student>> collect1_2 = students.stream()
            .collect(groupingBy(Student::getGrade));
        System.out.println("collect1_2 = " + collect1_2);

        // 2. 학년별로 학생들의 이름을 출력
        Map<Integer, List<String>> collect2 = students.stream()
            .collect(groupingBy(
                Student::getGrade,
                Collectors.mapping(Student::getName, Collectors.toList())
            ));
        System.out.println("collect2 = " + collect2);

        // 3. 학년별로 학생들의 수를 출력
        Map<Integer, Long> collect3 = students.stream()
            .collect(groupingBy(
                Student::getGrade,
                Collectors.counting()
            ));
        System.out.println("collect3 = " + collect3);

        // 4. 학년별로 학생들의 평균 점수를 출력
        Map<Integer, Double> collect4 = students.stream()
            .collect(groupingBy(
                Student::getGrade,
                Collectors.averagingInt(Student::getScore)
            ));
        System.out.println("collect4 = " + collect4);

        Map<Integer, IntSummaryStatistics> collect5 = students.stream()
            .collect(groupingBy(
                Student::getGrade,
                Collectors.summarizingInt(Student::getScore)
            ));
        System.out.println("collect5 = " + collect5);
    }
}
