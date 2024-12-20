package com.hoonjin.study.spring.msa.orderservice.service;

import com.hoonjin.study.spring.msa.orderservice.dto.OrderDto;
import com.hoonjin.study.spring.msa.orderservice.jpa.OrderEntity;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
