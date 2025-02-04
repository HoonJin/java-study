package com.hoonjin.study.java.was.v3;

import java.net.URLDecoder;
import java.net.URLEncoder;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PercentEncodingMain {

    public static void main(String[] args) {
        String encode = URLEncoder.encode("가", UTF_8);
        System.out.println("가 = " + encode);

        String decode = URLDecoder.decode(encode, UTF_8);
        System.out.println("%EA%B0%80 = " + decode);

        String encode2 = URLEncoder.encode("A", UTF_8);
        System.out.println("A = " + encode2);
    }
}
