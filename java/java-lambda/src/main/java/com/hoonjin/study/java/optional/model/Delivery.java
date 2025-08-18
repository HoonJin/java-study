package com.hoonjin.study.java.optional.model;

import lombok.Getter;

@Getter
public class Delivery {

    private String status;
    private boolean canceled;

    public Delivery(String status, boolean canceled) {
        this.status = status;
        this.canceled = canceled;
    }
}
