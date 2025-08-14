package com.hoonjin.study.java.optional.logger;

public class LogMain1 {

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.setDebug(true); // 디버그 모드 활성화
        logger.debug(10 + 20);

        System.out.println("debug off");
        logger.setDebug(false);
        logger.debug(100 + 200);
    }
}
