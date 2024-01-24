package com.hoonjin.study.java.basic.ref.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOrderMain3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int cnt = scanner.nextInt();
        scanner.nextLine(); // 버퍼비우기

        ProductOrder[] orders = new ProductOrder[cnt];
        for (int i = 0; i < orders.length; i++) {
            System.out.println(i + "번째 상품 입력");
            System.out.print("name: ");
            String name = scanner.nextLine();
            System.out.print("price: ");
            int price = scanner.nextInt();
            System.out.print("quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // 버퍼비우기

            orders[i] = createOrder(name, price, quantity);
        }

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
