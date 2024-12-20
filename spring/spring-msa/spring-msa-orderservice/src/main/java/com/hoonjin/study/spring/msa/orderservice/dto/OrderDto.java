package com.hoonjin.study.spring.msa.orderservice.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class OrderDto {

    private String productId;

    private Integer qty;

    private Integer unitPrice;
    private Integer totalPrice;

    @Setter
    private String userId;

    private String orderId;
}
