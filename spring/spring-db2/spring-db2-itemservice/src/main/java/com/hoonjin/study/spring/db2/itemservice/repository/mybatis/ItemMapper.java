package com.hoonjin.study.spring.db2.itemservice.repository.mybatis;

import com.hoonjin.study.spring.db2.itemservice.domain.Item;
import com.hoonjin.study.spring.db2.itemservice.repository.ItemSearchCond;
import com.hoonjin.study.spring.db2.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateDto);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearchCond);
}
