package com.hoonjin.study.java.annotation.validator;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ValidatorV2Main {

    public static void main(String[] args) {
        User user = new User("user1", 0);
        Team team = new Team("", 0);

        try {
            log("--- validate user ---");
            Validator.validate(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            log("--- validate team ---");
            Validator.validate(team);
        } catch (Exception e) {
            log(e);
        }
    }
}
