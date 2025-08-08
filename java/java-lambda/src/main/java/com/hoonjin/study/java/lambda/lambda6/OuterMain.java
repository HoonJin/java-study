package com.hoonjin.study.java.lambda.lambda6;

public class OuterMain {

    private String message = "외부 클래스";

    public void execute() {
        // 1. 익명 클래스 예시
        Runnable anonymous = new Runnable() {

            private String message = "익명 클래스";
            @Override
            public void run() {
                System.out.println("[익명클래스]this = " + this);
                System.out.println("[익명클래스]this.getClass() = " + this.getClass());
                System.out.println("[익명클래스]this.message = " + this.message);
            }
        };
        anonymous.run();

        System.out.println("-----------------------");

        // 2. 람다 표현식 예시
        Runnable lambda = () -> {
            // 여기의 this는 메인에서 생성한 OuterMain 인스턴스를 가리킴
            System.out.println("[람다]this = " + this);
            System.out.println("[람다]this.getClass() = " + this.getClass());
            System.out.println("[람다]this.message = " + this.message);
        };
        lambda.run();

    }

    public static void main(String[] args) {
        OuterMain outer = new OuterMain();
        System.out.println("외부 클래스 = " + outer);
        System.out.println("-----------------------");
        outer.execute();
    }
}
