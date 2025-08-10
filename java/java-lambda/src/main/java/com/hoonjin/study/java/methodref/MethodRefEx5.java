package com.hoonjin.study.java.methodref;

import com.hoonjin.study.java.lambda.lambda5.mystream.MyStreamV3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx5 {

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Kim"),
            new Person("Park"),
            new Person("Lee")
        );

//        List<String> result = MyStreamV3.of(people)
//            .map(p -> p.introduce())
//            .map(s -> s.toUpperCase())
//            .toList();
        List<String> result = MyStreamV3.of(people)
            .map(Person::introduce)
            .map(String::toUpperCase)
            .toList();
        System.out.println("result = " + result);
    }
}
