package com.hoonjin.study.spring.db2.itemservice.repository.jpa;

import com.hoonjin.study.spring.db2.itemservice.domain.Item;
import com.hoonjin.study.spring.db2.itemservice.repository.ItemRepository;
import com.hoonjin.study.spring.db2.itemservice.repository.ItemSearchCond;
import com.hoonjin.study.spring.db2.itemservice.repository.ItemUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Transactional
public class JpaItemRepositoryV2 implements ItemRepository {

    private final SpringDataJpaItemRepository repository;

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item item = repository.findById(itemId).orElseThrow();
        item.setItemName(updateParam.getItemName());
        item.setPrice(updateParam.getPrice());
        item.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();
        if (StringUtils.hasText(itemName) && maxPrice != null)
            // return repository.findByItemNameLikeAndPriceLessThanEqual("%" + itemName + "%", maxPrice);
            return repository.findItems("%" + itemName + "%", maxPrice);
        else if (StringUtils.hasText(itemName))
            return repository.findByItemNameLike("%" + itemName + "%");
        else if (maxPrice != null)
            return repository.findByPriceLessThanEqual(maxPrice);
        else
            return repository.findAll();
    }
}
