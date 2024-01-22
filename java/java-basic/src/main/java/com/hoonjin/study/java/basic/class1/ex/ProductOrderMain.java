package com.hoonjin.study.java.basic.class1.ex;

public class ProductOrderMain {

    public static void main(String[] args) {
        ProductOrder product0 = new ProductOrder();
        product0.productName = "두부";
        product0.price = 1000;
        product0.quantity = 2;

        ProductOrder product1 = new ProductOrder();
        product1.productName = "김치";
        product1.price = 5000;
        product1.quantity = 1;

        ProductOrder product2 = new ProductOrder();
        product2.productName = "콜라";
        product2.price = 2000;
        product2.quantity = 2;

        int total = 0;
        ProductOrder[] orders = {product0, product1, product2};
        for (ProductOrder order : orders) {
            System.out.println("order.productName = " + order.productName + ", order.price = " + order.price + ", order.quantity = " + order.quantity);
            total += order.price * order.quantity;
        }

        System.out.println("total = " + total);
    }
}
