package com.hoonjin.study.java.annotation.basic;

import com.hoonjin.study.java.util.MyLogger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnoElement {

    String value();

    int count() default 0;

    String[] tags() default {};

    // MyLogger data() 다른 타입은 적용 x
    Class<? extends MyLogger> annoData() default MyLogger.class;

}
