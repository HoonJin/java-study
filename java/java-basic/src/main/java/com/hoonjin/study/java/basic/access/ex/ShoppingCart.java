package com.hoonjin.study.java.basic.access.ex;

import java.util.Arrays;
import java.util.Objects;

public class ShoppingCart {

    private Item[] items = new Item[10];
    private int currentSize;

    public void addItem(Item item) {
        if (currentSize >= items.length) {
            System.out.println("can't add cart");
            return;
        }

        items[currentSize] = item;
        currentSize++;
    }

    public void displayItems() {
        for (Item item : items) {
            if (item == null) {
                continue;
            }
            System.out.println("Name = " + item.getName() + ", totalPrice = " + item.getTotalPrice());
        }
        System.out.println("calculateTotalPrice = " + calculateTotalPrice());
    }

    private int calculateTotalPrice() {
        return Arrays.stream(items)
            .filter(Objects::nonNull)
            .map(Item::getTotalPrice)
            .reduce(0, Integer::sum);
    }
}
