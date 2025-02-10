package com.hoonjin.study.java.annotation.validator;

import lombok.Getter;

@Getter
public class Team {

    @NotEmpty
    private String name;

    @Range(min = 1, max = 999)
    private int memberCount;

    public Team(String name, int memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }
}
