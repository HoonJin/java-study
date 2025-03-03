package com.hoonjin.study.java.reflection;

import com.hoonjin.study.java.reflection.data.Calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodV3 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("호출할 메서드: ");
        String methodName = scanner.nextLine();

        System.out.print("숫자1: ");
        int a = scanner.nextInt();
        System.out.print("숫자2: ");
        int b = scanner.nextInt();

        Calculator calculator = new Calculator();
        Class<? extends Calculator> aClass = calculator.getClass();
        Method method = aClass.getMethod(methodName, int.class, int.class);
        Object result = method.invoke(calculator, a, b);

        System.out.println("result = " + result);
    }
}
