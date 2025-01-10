package com.hoonjin.study.java.ionetwork.io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static com.hoonjin.study.java.ionetwork.io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {
        String str = "ABC";
        byte[] bytes = str.getBytes(UTF_8);
        System.out.println("str = " + str);
        System.out.println("bytes = " + Arrays.toString(bytes));

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            fos.write(bytes);
        }

        byte[] readBytes;
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            readBytes = fis.readAllBytes();
        }
        String readStr = new String(readBytes, UTF_8);
        System.out.println("readBytes = " + Arrays.toString(readBytes));
        System.out.println("readStr = " + readStr);

    }
}
