package com.hoonjin.study.java.stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class DownStreamMain2 {

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
        Map<Integer, List<Student>> collect1 = students.stream()
            .collect(groupingBy(Student::getGrade));
        System.out.println("collect1 = " + collect1);

        // 2. 학년별로 가장 높은 학생의 점수를 구하라. reducing 사용
        Map<Integer, Optional<Student>> collect2 = students.stream()
            .collect(groupingBy(
                Student::getGrade,
                Collectors.reducing(
                    (s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2
                )
            ));
        System.out.println("collect2 = " + collect2);

        // 3. 학년별로 가장 높은 학생의 점수를 구하라. maxBy 사용
        Map<Integer, Optional<Student>> collect3 = students.stream()
            .collect(groupingBy(
                Student::getGrade,
//                Collectors.maxBy((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
                Collectors.maxBy(Comparator.comparingInt(Student::getScore))
            ));
        System.out.println("collect3 = " + collect3);

        // 4. 학년별로 가장 높은 학생의 이름을 구하라. Collectors.collectingAndThen 사용
        Map<Integer, Optional<String>> collect4 = students.stream()
            .collect(groupingBy(
                Student::getGrade,
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingInt(Student::getScore)),
                    opt -> opt.map(Student::getName)
                )
            ));
        System.out.println("collect4 = " + collect4);

    }
}
