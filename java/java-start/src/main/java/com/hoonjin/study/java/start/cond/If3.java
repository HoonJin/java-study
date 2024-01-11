package com.hoonjin.study.java.start.cond;

public class If3 {

    public static void main(String[] args) {
        int age = 12;

        // 하나의 결과를 원하지만 사실 각기 별개의 if문
        if (age <= 7) {
            System.out.println("미취학");
        }
        if (7 < age && age <= 13) {
            System.out.println("초등학생");
        }
        if (13 < age && age <= 16) {
            System.out.println("중학생");
        }
        if (16 < age && age <= 19) {
            System.out.println("고등학생");
        }
        if (age > 20){ // if, else if 조건에 만족하지 않을때 실행
            System.out.println("성인");
        }

        // 하나의 결과를 원하는 여러개의 if문을 하나로 묶어준다.
        // 순서대로 맞는 조건을 찾아보기 때문에 조건이 단순해진다.
        if (age <= 7) {
            System.out.println("미취학");
        } else if (age <= 13) { // 이미 7 이하는 위의 조건에서 필터링되어서 8 ~ 13을 체크한다.
            System.out.println("초등학생");
        } else if (age <= 16) {
            System.out.println("중학생");
        } else if (age <= 19) {
            System.out.println("고등학생");
        } else { // if, else if 조건에 만족하지 않을때 실행
            System.out.println("성인");
        }
    }
}
