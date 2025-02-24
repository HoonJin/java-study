package com.hoonjin.study.java.basic.poly.ex.pay0;

public class PayService {

    public void processPay(String option, int amount) {
        System.out.println("processPay option = " + option + ", amount = " + amount);

        boolean result;
        if (option.equals("kakao")) {
            KakaoPay kakaoPay = new KakaoPay();
            result = kakaoPay.pay(amount);
        } else if (option.equals("naver")) {
            NaverPay naverPay = new NaverPay();
            result = naverPay.pay(amount);
        } else {
            System.out.println("wrong option");
            result = false;
        }

        if (result) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }
}
