package com.hoonjin.study.spring.db2.itemservice.service;

import com.hoonjin.study.spring.db2.itemservice.domain.Item;
import com.hoonjin.study.spring.db2.itemservice.repository.ItemSearchCond;
import com.hoonjin.study.spring.db2.itemservice.repository.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}
