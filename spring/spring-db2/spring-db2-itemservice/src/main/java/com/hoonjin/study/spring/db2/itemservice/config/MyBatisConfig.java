package com.hoonjin.study.spring.db2.itemservice.config;

import com.hoonjin.study.spring.db2.itemservice.repository.ItemRepository;
import com.hoonjin.study.spring.db2.itemservice.repository.mybatis.ItemMapper;
import com.hoonjin.study.spring.db2.itemservice.repository.mybatis.MyBatisItemRepository;
import com.hoonjin.study.spring.db2.itemservice.service.ItemService;
import com.hoonjin.study.spring.db2.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final ItemMapper itemMapper;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MyBatisItemRepository(itemMapper);
    }

}
