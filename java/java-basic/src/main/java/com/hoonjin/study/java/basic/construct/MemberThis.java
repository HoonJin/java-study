package com.hoonjin.study.java.basic.construct;

public class MemberThis {
    String nameField;

    void initMember(String nameParam) {
        // 클래스 변수와 파라미터 이름이 다르면 this 생략 가능하다.
        nameField = nameParam;
        // 하지만 항상 this 를 명시하는 스타일도 있다.
        // 다만 최근에는 IDE가 너무 좋아서 구분이 잘 되어 굳이 사용하지 않는 추세이다.
        //this.nameField = nameParam;
    }
}
