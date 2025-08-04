package com.hoonjin.study.java.lambda.ex2;

public class ComposeExample {

    // MyTransformer 인터페이스를 사용하여 두 개의 함수를 합성하는 메서드
    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return s -> f2.transform(f1.transform(s));
    }

    // 익명 클래스를 사용하여 두 개의 함수를 합성하는 메서드
    public static MyTransformer composeAnonymous(MyTransformer f1, MyTransformer f2) {
        return new MyTransformer() {
            @Override
            public String transform(String s) {
                String intermediate = f1.transform(s);
                return f2.transform(intermediate);
            }
        };
    }

    public static void main(String[] args) {
        MyTransformer toUpper = s -> s.toUpperCase();
        MyTransformer deco = s -> "**" + s + "**";

        MyTransformer compose = compose(toUpper, deco);
        String result = compose.transform("hello");
        System.out.println("result = " + result);
    }
}
