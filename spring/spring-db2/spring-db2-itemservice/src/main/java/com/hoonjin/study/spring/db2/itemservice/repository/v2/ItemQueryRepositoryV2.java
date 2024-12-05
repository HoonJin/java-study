package com.hoonjin.study.spring.db2.itemservice.repository.v2;

import com.hoonjin.study.spring.db2.itemservice.domain.Item;
import com.hoonjin.study.spring.db2.itemservice.repository.ItemSearchCond;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.hoonjin.study.spring.db2.itemservice.domain.QItem.item;


@Repository
public class ItemQueryRepositoryV2 {

    private final JPAQueryFactory jpaQueryFactory;

    public ItemQueryRepositoryV2(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        return jpaQueryFactory.select(item)
                .from(item)
                .where(
                        likeItemName(itemName),
                        priceLoe(maxPrice)
                )
                .fetch();
    }

    private BooleanExpression likeItemName(String itemName) {
        if (StringUtils.hasText(itemName))
            return item.itemName.like("%" + itemName + "%");
        else
            return null;
    }

    private BooleanExpression priceLoe(Integer maxPrice) {
        return maxPrice != null
                ? item.price.loe(maxPrice)
                : null;
    }
}
