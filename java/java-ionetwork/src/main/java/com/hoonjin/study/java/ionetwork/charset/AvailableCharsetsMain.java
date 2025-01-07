package com.hoonjin.study.java.ionetwork.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetsMain {

    public static void main(String[] args) {
        // 이용 가능한 모든 charset: java and OS
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        charsets.forEach((s, charset) -> System.out.println("charsetName = " + s));

        System.out.println("===");
        Charset charset1 = Charset.forName("MS949");
        System.out.println("charset1 = " + charset1);

        Set<String> aliases = charset1.aliases();
        for (String alias : aliases) {
            System.out.println("alias = " + alias);
        }

//        Charset charset2 = Charset.forName("UTF-8");
//        System.out.println("charset2 = " + charset2);

        Charset charset3 = StandardCharsets.UTF_8;
        System.out.println("charset3 = " + charset3);

        Charset charset4 = Charset.defaultCharset();
        System.out.println("charset4 = " + charset4);
    }
}
