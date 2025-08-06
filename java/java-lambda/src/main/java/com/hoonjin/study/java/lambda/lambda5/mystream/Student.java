package com.hoonjin.study.java.lambda.lambda5.mystream;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
