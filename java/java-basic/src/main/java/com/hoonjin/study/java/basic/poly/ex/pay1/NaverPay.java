package com.hoonjin.study.java.basic.poly.ex.pay1;

public class NaverPay implements Pay {

    @Override
    public boolean pay(int amount) {
        System.out.println("connect to NaverPay");
        System.out.println("try to pay " + amount);
        return true;
    }
}
