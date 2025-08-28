package com.hoonjin.study.spring.grpc.client;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChannelConfig {

    @Bean
    Channel channel() {
        return ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();
    }
}
