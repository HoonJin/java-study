package com.hoonjin.study.spring.db2.itemservice.config;

import com.hoonjin.study.spring.db2.itemservice.repository.ItemRepository;
import com.hoonjin.study.spring.db2.itemservice.repository.jpa.JpaItemRepositoryV2;
import com.hoonjin.study.spring.db2.itemservice.repository.jpa.SpringDataJpaItemRepository;
import com.hoonjin.study.spring.db2.itemservice.service.ItemService;
import com.hoonjin.study.spring.db2.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDataJpaConfig {

    private final SpringDataJpaItemRepository repository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV2(repository);
    }

}