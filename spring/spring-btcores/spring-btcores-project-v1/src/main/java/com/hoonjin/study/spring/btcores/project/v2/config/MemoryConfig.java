package com.hoonjin.study.spring.btcores.project.v2.config;

import memory.v1.MemoryController;
import memory.v1.MemoryFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }

    @Bean
    public MemoryController memoryController(MemoryFinder memoryFinder) {
        return new MemoryController(memoryFinder);
    }
}
