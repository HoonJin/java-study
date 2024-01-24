package com.hoonjin.study.java.basic.ref.ex;

import java.util.Arrays;

public class ProductOrderMain2 {

    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];
        orders[0] = createOrder("두부",1000,2);
        orders[1] = createOrder("김치", 5000, 1);
        orders[2] = createOrder("콜라", 2000, 2);

        printOrders(orders);
        int totalAmount = getTotalAmount(orders);
        System.out.println("totalAmount = " + totalAmount);
    }

    public static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder product = new ProductOrder();
        product.productName = productName;
        product.price = price;
        product.quantity = quantity;
        return product;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("order.productName = " + order.productName + ", order.price = " + order.price + ", order.quantity = " + order.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        return Arrays.stream(orders).map(o -> o.price * o.quantity).reduce(0, Integer::sum);
    }
}
