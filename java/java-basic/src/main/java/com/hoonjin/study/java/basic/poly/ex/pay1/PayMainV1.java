package com.hoonjin.study.java.basic.poly.ex.pay1;

public class PayMainV1 {

    public static void main(String[] args) {
        PayService payService = new PayService();

        String option1 = "kakao";
        int amount1 = 5000;
        payService.processPay(option1, amount1);

        String option2 = "naver";
        int amount2 = 1000;
        payService.processPay(option2, amount2);

        String option3 = "bad";
        int amount3 = 5000;
        payService.processPay(option3, amount3);

        // 새로운 요구사항  new pay
        String option4 = "new";
        int amount4 = 5000;
        payService.processPay(option4, amount4);
    }
}
