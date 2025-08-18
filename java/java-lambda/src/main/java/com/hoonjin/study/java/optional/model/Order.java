package com.hoonjin.study.java.optional.model;

import lombok.Getter;

@Getter
public class Order {

    private Long id;
    private Delivery delivery;

    public Order(Long id, Delivery delivery) {
        this.id = id;
        this.delivery = delivery;
    }
}
