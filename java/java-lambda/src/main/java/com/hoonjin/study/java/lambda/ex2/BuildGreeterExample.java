package com.hoonjin.study.java.lambda.ex2;

public class BuildGreeterExample {

    public static StringFunction buildGreeter(String greeting) {
        return name -> greeting + ", " + name;
    }

    public static void main(String[] args) {
        StringFunction helloGreeter = buildGreeter("Hello");
        StringFunction hiGreeter = buildGreeter("Hi");

        String result1 = helloGreeter.apply("java");
        System.out.println("hello = " + result1);
        String result2 = hiGreeter.apply("java");
        System.out.println("hi = " + result2);
    }
}
