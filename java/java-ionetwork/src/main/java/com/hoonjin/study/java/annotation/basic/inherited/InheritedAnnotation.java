package com.hoonjin.study.java.annotation.basic.inherited;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited // 클래스 상속시 자식도 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedAnnotation {
}
