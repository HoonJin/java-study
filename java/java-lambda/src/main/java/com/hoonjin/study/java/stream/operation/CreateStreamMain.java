package com.hoonjin.study.java.stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamMain {

    public static void main(String[] args) {
        System.out.println("1. 컬렉션으로부터 생성");
        List<String> list = List.of("a", "b", "c");
        list.stream()
            .forEach(System.out::println);

        System.out.println("2. 배열로부터 생성");
        String[] array = {"a", "b", "c"};
        Arrays.stream(array)
            .forEach(System.out::println);

        System.out.println("3. Stream.of()로 생성");
        Stream.of("a", "b", "c")
            .forEach(System.out::println);

        System.out.println("4. 무한 스트림 생성 - Stream.iterate()로 생성");
        // iterate: 초기값과 다음값을 만드는 함수를 지정
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        infiniteStream.limit(3) // 무한 스트림이므로 limit로 개수 제한
            .forEach(System.out::println);

        System.out.println("5. 무한 스트림 생성 - Stream.generate()로 생성");
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(3)
            .forEach(System.out::println);
    }
}
