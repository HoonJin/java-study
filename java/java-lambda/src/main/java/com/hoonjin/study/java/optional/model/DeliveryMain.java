package com.hoonjin.study.java.optional.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DeliveryMain {

    static Map<Long, Order> orderRepository = new HashMap<>();

    static {
        orderRepository.put(1L, new Order(1L, new Delivery("배송완료", false)));
        orderRepository.put(2L, new Order(2L, new Delivery("배송중", false)));
        orderRepository.put(3L, new Order(3L, new Delivery("배송중", true)));
        orderRepository.put(4L, new Order(4L, null));
    }

    public static void main(String[] args) {
        System.out.println("Order 1 Delivery Status: " + getDeliveryStatus(1L));
        System.out.println("Order 2 Delivery Status: " + getDeliveryStatus(2L));
        System.out.println("Order 3 Delivery Status: " + getDeliveryStatus(3L));
        System.out.println("Order 4 Delivery Status: " + getDeliveryStatus(4L));
    }

    private static String getDeliveryStatus(long orderId) {
        return findOrder(orderId)
            .map(Order::getDelivery)
            .filter(delivery -> !delivery.isCanceled())
            .map(Delivery::getStatus)
            .orElse("배송정보 없음");
    }

    static Optional<Order> findOrder(long orderId) {
        return Optional.ofNullable(orderRepository.get(orderId));
    }
}
