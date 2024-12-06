package com.hoonjin.study.spring.mvc2.validation.web.form;

import com.hoonjin.study.spring.mvc2.validation.domain.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ItemSaveForm {

    // id는 필요 없다.

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 10000000)
    private Integer price;

    private Integer quantity;

    public Item toEntity() {
        return new Item(itemName, price, quantity);
    }
}
