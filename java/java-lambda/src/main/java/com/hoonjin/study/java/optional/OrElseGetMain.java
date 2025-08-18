package com.hoonjin.study.java.optional;

import java.util.Optional;
import java.util.Random;

public class OrElseGetMain {

    public static void main(String[] args) {
        Optional<Integer> optValue = Optional.of(100);
        Optional<Integer> optEmpty = Optional.empty();

        System.out.println("단순계산");
        Integer i1 = optValue.orElse(10 + 20); // 10 + 20 계산후 버림
        Integer i2 = optEmpty.orElse(10 + 20); // 10 + 20 계산후 사용
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);

        // 값이 있으면 그 값, 없으면 지정된 기본값 사용
        System.out.println("== orElse ==");
        System.out.println("값이 있는 경우");
        Integer value1 = optValue.orElse(createData());
        System.out.println("value1 = " + value1);

        System.out.println("값이 없는 경우");
        Integer empty1 = optEmpty.orElse(createData());
        System.out.println("empty1 = " + empty1);

        // 값이 있으면 그 값, 없으면 지정된 Supplier를 실행하여 반환
        System.out.println("== orElseGet ==");
        System.out.println("값이 있는 경우");
        Integer value2 = optValue.orElseGet(OrElseGetMain::createData);
        System.out.println("value2 = " + value2);

        System.out.println("값이 없는 경우");
        Integer empty2 = optEmpty.orElseGet(OrElseGetMain::createData);
        System.out.println("empty2 = " + empty2);

    }

    static int createData() {
        System.out.println("createData() 호출");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int generatedValue = new Random().nextInt(100);
        System.out.println("generatedValue = " + generatedValue);
        return generatedValue;
    }
}
