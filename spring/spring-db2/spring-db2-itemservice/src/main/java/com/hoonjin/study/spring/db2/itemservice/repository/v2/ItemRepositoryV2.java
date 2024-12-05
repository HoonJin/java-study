package com.hoonjin.study.spring.db2.itemservice.repository.v2;

import com.hoonjin.study.spring.db2.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV2 extends JpaRepository<Item, Long> {
}
