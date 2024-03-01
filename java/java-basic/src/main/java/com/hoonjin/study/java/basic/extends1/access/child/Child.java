package com.hoonjin.study.java.basic.extends1.access.child;

import com.hoonjin.study.java.basic.extends1.access.parent.Parent;

public class Child extends Parent {

    public void call() {
        publicValue = 1;
        protectedValue = 1; // 상속관계 or 같은 패키지
        // defaultValue = 1; // 다른 패키지여서 접근 불가
        // privateValue = 1; // 당연히 불가

        publicMethod();
        protectedMethod();
        //defaultMethod();
        //privateMethod();

        printParent();
    }
}
