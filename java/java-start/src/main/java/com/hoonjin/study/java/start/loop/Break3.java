package com.hoonjin.study.java.start.loop;

public class Break3 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; ; i++) { // 무한루프
            // 여기서의 i는 for 구문 블록에서만 쓸 수 있다.
            sum += i;
            if (sum > 10) {
                System.out.println("합이 10보다 크면 종료. sum = " + sum + ", i = " + i);
                break;
            }
        }
    }
}
