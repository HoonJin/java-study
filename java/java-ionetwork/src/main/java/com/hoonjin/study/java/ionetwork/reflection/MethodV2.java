package com.hoonjin.study.java.ionetwork.reflection;

import com.hoonjin.study.java.ionetwork.reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 정적 메서드 호출 - 일반적인 메서드 호출
        BasicData instance = new BasicData();
        instance.call(); // 이 부분은 코드를 변경하지 않는 이상 정적이다.

        // 동적 메서드 호출 - 리플렉션 사용
        Class<? extends BasicData> basicClass = instance.getClass();
        String methodName = "hello";

        // 메서드 이름을 변수로 변경할 수 있다.
        Method method = basicClass.getDeclaredMethod(methodName, String.class); // accessor 와 관계없이 호출 가능
        System.out.println("method = " + method);
        Object result = method.invoke(instance, "HI");
        System.out.println("result = " + result);
    }
}
