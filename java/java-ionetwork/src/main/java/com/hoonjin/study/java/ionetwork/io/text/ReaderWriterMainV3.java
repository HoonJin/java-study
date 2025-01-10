package com.hoonjin.study.java.ionetwork.io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.hoonjin.study.java.ionetwork.io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV3 {

    public static void main(String[] args) throws IOException {
        String str = "ABC";
        System.out.println("str = " + str);

        try (FileWriter fileWriter = new FileWriter(FILE_NAME, UTF_8)) {
            fileWriter.write(str);
        }

        StringBuilder builder = new StringBuilder();
        try (FileReader fileReader = new FileReader(FILE_NAME, UTF_8)) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                builder.append((char) ch);
            }
        }
        System.out.println("builder = " + builder);
    }
}
