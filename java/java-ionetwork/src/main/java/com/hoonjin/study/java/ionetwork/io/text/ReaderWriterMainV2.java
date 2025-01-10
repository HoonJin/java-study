package com.hoonjin.study.java.ionetwork.io.text;

import java.io.*;

import static com.hoonjin.study.java.ionetwork.io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV2 {

    public static void main(String[] args) throws IOException {
        String str = "가나다";
        System.out.println("str = " + str);

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8)) {
            osw.write(str);
        }

        StringBuilder builder = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             InputStreamReader isr = new InputStreamReader(fis, UTF_8)) {
            int ch;
            while ((ch = isr.read()) != -1) {
                builder.append((char) ch);
            }
        }

        System.out.println("builder = " + builder);
    }
}
