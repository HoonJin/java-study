package com.hoonjin.study.java.lambda.lambda4;

import java.util.function.*;

public class PrimitiveFunction {

    public static void main(String[] args) {
        // 기본형 매개변수
        IntFunction<String> function = x -> "숫지: " + x;
        System.out.println("function.apply(10) = " + function.apply(10));

        // 기본형 반환
        ToIntFunction<String> toIntFunction = x -> x.length();
        System.out.println("toIntFunction.applyAsInt(\"hello\") = " + toIntFunction.applyAsInt("hello"));

        // 기본형 매개변수, 기본형 반환
        IntToLongFunction intToLongFunction = x -> x * 1000L;
        System.out.println("intToLongFunction.applyAsLong(10) = " + intToLongFunction.applyAsLong(10));

        // IntUnaryOperator int -> int;
        IntUnaryOperator intUnaryOperator = x -> x * x;
        System.out.println("intUnaryOperator.applyAsInt(5) = " + intUnaryOperator.applyAsInt(5));

        // intConsumer, IntSupplier, IntPredicate, IntBinaryOperator 등 primitive 타입을 사용하는 함수형 인터페이스들
        IntConsumer intConsumer = x -> System.out.println(x);
        intConsumer.accept(100);
    }
}
