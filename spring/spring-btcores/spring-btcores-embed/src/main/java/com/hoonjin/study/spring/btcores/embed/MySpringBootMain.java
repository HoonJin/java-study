package com.hoonjin.study.spring.btcores.embed;

import com.hoonjin.study.spring.btcores.embed.boot.MySpringApplication;
import com.hoonjin.study.spring.btcores.embed.boot.MySpringBootApplication;

@MySpringBootApplication
public class MySpringBootMain {

    public static void main(String[] args) {
        System.out.println("MySpringBootMain.main");
        MySpringApplication.run(MySpringBootMain.class, args);
    }
}
