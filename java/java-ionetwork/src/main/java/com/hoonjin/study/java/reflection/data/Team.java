package com.hoonjin.study.java.reflection.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Team {

    private String id;
    private String name;

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
