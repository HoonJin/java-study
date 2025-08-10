package com.hoonjin.study.java.methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx4 {

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Kim"),
            new Person("Park"),
            new Person("Lee")
        );

//        List<String> result = mapPersonToString(people, p -> p.introduce());
        List<String> result = mapPersonToString(people, Person::introduce);
        System.out.println("result = " + result);

//        List<String> upperResult = mapStringToString(result, s -> s.toUpperCase());
        List<String> upperResult = mapStringToString(result, String::toUpperCase);
        System.out.println("upperResult = " + upperResult);
    }

    static List<String> mapPersonToString(List<Person> people, Function<Person, String> fun) {
        ArrayList<String> result = new ArrayList<>();
        for (Person person : people) {
            result.add(fun.apply(person));
        }
        return result;
    }

    static List<String> mapStringToString(List<String> strings, Function<String, String> fun) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : strings) {
            result.add(fun.apply(s));
        }
        return result;
    }
}
