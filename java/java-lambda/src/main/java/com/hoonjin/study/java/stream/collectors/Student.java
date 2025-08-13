package com.hoonjin.study.java.stream.collectors;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Student {

    private String name;
    private int grade;
    private int score;

    public Student(String name, int grade, int score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }
}
