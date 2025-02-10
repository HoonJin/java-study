package com.hoonjin.study.java.annotation.validator;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ValidatorV1Main {

    public static void main(String[] args) {
        User user = new User("user1", 0);
        Team team = new Team("", 0);

        try {
            log("--- validate user ---");
            validateUser(user);
        } catch (RuntimeException e) {
            log(e);
        }

        try {
            log("--- validate team ---");
            validateTeam(team);
        } catch (RuntimeException e) {
            log(e);
        }
    }

    private static void validateUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new RuntimeException("name is empty");
        }

        if (user.getAge() < 1 || user.getAge() > 100) {
            throw new RuntimeException("age have to big then 1 and less then 100");
        }
    }


    private static void validateTeam(Team team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new RuntimeException("name is empty");
        }

        if (team.getMemberCount() < 1 || team.getMemberCount() > 999) {
            throw new RuntimeException("age have to big then 1 and less then 100");
        }
    }
}
