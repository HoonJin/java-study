package com.hoonjin.study.java.annotation.java;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class SuppressWarningCase {

    @SuppressWarnings("unused")
    public void unusedWarning() {
        int unusedVariable = 10;
    }

    @SuppressWarnings("deprecation")
    public void deprecatedMethod() {
        java.util.Date date = new java.util.Date();
        int date1 = date.getDate();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void uncheckedCast() {
        // raw type 사용 경고
        List list = new ArrayList();

        // 제네릭 타입 관련 경고
        List<String> stringList = (List<String>) list;
    }

    @SuppressWarnings("all")
    public void suppressAll() {
        int unusedVariable = 10;
        java.util.Date date = new java.util.Date();
        int date1 = date.getDate();
    }
}
