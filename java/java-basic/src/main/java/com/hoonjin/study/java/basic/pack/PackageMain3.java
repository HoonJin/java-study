package com.hoonjin.study.java.basic.pack;

import com.hoonjin.study.java.basic.pack.a.User;

public class PackageMain3 {

    public static void main(String[] args) {
        User userA = new User();
        //com.hoonjin.study.java.basic.pack.a.User userA = new com.hoonjin.study.java.basic.pack.a.User();

        com.hoonjin.study.java.basic.pack.b.User userB = new com.hoonjin.study.java.basic.pack.b.User();
    }
}
