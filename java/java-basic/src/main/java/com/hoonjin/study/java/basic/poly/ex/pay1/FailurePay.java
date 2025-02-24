package com.hoonjin.study.java.basic.poly.ex.pay1;

public class FailurePay implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}
