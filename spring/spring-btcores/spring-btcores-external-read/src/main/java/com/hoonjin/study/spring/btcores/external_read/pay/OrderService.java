package com.hoonjin.study.spring.btcores.external_read.pay;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final PayClient payClient;

    public void order(int money) {
        // many order logic
        payClient.pay(money);
    }

}
