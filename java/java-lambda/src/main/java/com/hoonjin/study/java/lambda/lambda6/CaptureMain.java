package com.hoonjin.study.java.lambda.lambda6;

public class CaptureMain {

    public static void main(String[] args) {
        final int final1 = 10;
        int final2 = 20;
        int changedVar = 30;

        // 익명 클래스에서의 캡쳐
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명클래스 final1 = " + final1);
                System.out.println("익명클래스 final2 = " + final2);

                // compile error
//                System.out.println("익명클래스 changedVar = " + changedVar);
            }
        };
        runnable.run();

        System.out.println("-----------------------");

        // 람다의 캡쳐
        Runnable lambda = () -> {
            System.out.println("람다 final1 = " + final1);
            System.out.println("람다 final2 = " + final2);

            // compile error
//            System.out.println("람다 changedVar = " + changedVar);
        };
        lambda.run();
        changedVar = 20;
    }
}
