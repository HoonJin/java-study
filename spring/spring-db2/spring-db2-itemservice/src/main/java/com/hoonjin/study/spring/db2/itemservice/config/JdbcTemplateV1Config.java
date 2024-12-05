package com.hoonjin.study.spring.db2.itemservice.config;

import com.hoonjin.study.spring.db2.itemservice.repository.ItemRepository;
import com.hoonjin.study.spring.db2.itemservice.repository.jdbctemplate.JdbcTemplateItemRepositoryV2;
import com.hoonjin.study.spring.db2.itemservice.service.ItemService;
import com.hoonjin.study.spring.db2.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateV1Config {

    private final DataSource dataSource;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JdbcTemplateItemRepositoryV2(dataSource);
    }

}
