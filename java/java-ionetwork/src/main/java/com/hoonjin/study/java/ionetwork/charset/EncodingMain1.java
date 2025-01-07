package com.hoonjin.study.java.ionetwork.charset;

import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("english");
        encoding("A", US_ASCII);
        encoding("A", ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", UTF_8);
        encoding("A", UTF_16BE); // 2byte

        System.out.println("한글");
        encoding("가", EUC_KR);
        encoding("가", MS_949);
        encoding("가", UTF_8); // 3byte
        encoding("가", UTF_16BE); // 2byte 그러나 다른 값

//        String str = "A";
//        byte[] bytes = str.getBytes(); // system encoding
//        System.out.println("bytes = " + Arrays.toString(bytes));
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> %s 인코딩 -> %s %sbyte \n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}
