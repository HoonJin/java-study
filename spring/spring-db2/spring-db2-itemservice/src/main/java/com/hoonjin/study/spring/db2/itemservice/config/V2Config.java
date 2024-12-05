package com.hoonjin.study.spring.db2.itemservice.config;

import com.hoonjin.study.spring.db2.itemservice.repository.ItemRepository;
import com.hoonjin.study.spring.db2.itemservice.repository.jpa.JpaItemRepositoryV3;
import com.hoonjin.study.spring.db2.itemservice.repository.v2.ItemQueryRepositoryV2;
import com.hoonjin.study.spring.db2.itemservice.repository.v2.ItemRepositoryV2;
import com.hoonjin.study.spring.db2.itemservice.service.ItemService;
import com.hoonjin.study.spring.db2.itemservice.service.ItemServiceV2;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class V2Config {

    private final EntityManager em;
    private final ItemRepositoryV2 itemRepositoryV2;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemRepositoryV2, itemQueryRepositoryV2());
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepositoryV2() {
        return new ItemQueryRepositoryV2(em);
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV3(em);
    }

}
