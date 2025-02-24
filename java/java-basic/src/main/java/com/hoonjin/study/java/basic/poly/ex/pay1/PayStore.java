package com.hoonjin.study.java.basic.poly.ex.pay1;

public abstract class PayStore {

    public static Pay findPay(String option) {
//        if (option.equals("kakao")) {
//            return new KakaoPay();
//        } else if (option.equals("naver")) {
//            return new NaverPay();
//        } else if (option.equals("new")) {
//            return new NewPay();
//        } else {
////            return null;
//            // null object pattern
//            return new FailurePay();
//        }
        return switch (option) {
            case "kakao" -> new KakaoPay();
            case "naver" -> new NaverPay();
            case "new" -> new NewPay();
            default -> new FailurePay();
        };
    }
}
