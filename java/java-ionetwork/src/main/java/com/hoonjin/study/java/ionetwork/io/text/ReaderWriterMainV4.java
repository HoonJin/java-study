package com.hoonjin.study.java.ionetwork.io.text;

import java.io.*;

import static com.hoonjin.study.java.ionetwork.io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String str = "ABC\n가나다";
        System.out.println("str = " + str);

        try (FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
             BufferedWriter writer = new BufferedWriter(fw, BUFFER_SIZE)) {
            writer.write(str);
        }

        StringBuilder builder = new StringBuilder();
        try (FileReader fs = new FileReader(FILE_NAME, UTF_8);
             BufferedReader reader = new BufferedReader(fs, BUFFER_SIZE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        }
        System.out.println("builder = " + builder);
    }
}
