package com.hoonjin.study.java.basic.poly.ex.pay1;

public class PayService {

    public void processPay(String option, int amount) {
        System.out.println("processPay option = " + option + ", amount = " + amount);

        Pay pay = PayStore.findPay(option);
//        if (pay != null) {
//            result = pay.pay(amount);
//        }
        // null object pattern 적용 후 서비스 코드에서 null 체크 불필요
        boolean result = pay.pay(amount);

        if (result) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }
}
