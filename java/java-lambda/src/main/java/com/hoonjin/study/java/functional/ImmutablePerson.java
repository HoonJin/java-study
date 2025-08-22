package com.hoonjin.study.java.functional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class ImmutablePerson {
    private final String name;
    private final int age;

    // 변경이 필요하면 새 객체를 반환
    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge);
    }
}
