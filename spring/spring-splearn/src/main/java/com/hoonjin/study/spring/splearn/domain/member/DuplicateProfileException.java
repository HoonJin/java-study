package com.hoonjin.study.spring.splearn.domain.member;

public class DuplicateProfileException extends RuntimeException {

    public DuplicateProfileException(String message) {
        super(message);
    }
}
