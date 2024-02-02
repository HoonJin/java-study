package com.hoonjin.study.java.basic.static1;

public class DataCountMain3 {

    public static void main(String[] args) {

        Data3 data1 = new Data3("A");
        System.out.println("Data3.count = " + Data3.count);

        Data3 data2 = new Data3("B");
        System.out.println("Data3.count = " + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("Data3.count = " + Data3.count);


        Data3 data4 = new Data3("D");
        // 인스턴스를 통한 접근 // 사실 정적 변수이니 다시 정적 메모리 영역의 값 참조
        // 권장하지 않음. 스태틱 변수인데, 인스턴스 변수를 쓰는 것 처럼 오해할 수 있음
        System.out.println("data4.count = " + data4.count);
        // 클래스를 통한 접근
        System.out.println("Data3.count = " + Data3.count);
    }
}
