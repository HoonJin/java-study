package com.hoonjin.study.spring.btcores.external_read.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Profile("!prod")
@Service
public class LocalPayClient implements PayClient {
    @Override
    public void pay(int money) {
        log.info("로컬 결제 {} 원", money);
    }
}
