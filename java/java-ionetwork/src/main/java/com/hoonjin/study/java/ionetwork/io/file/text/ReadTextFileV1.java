package com.hoonjin.study.java.ionetwork.io.file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV1 {

    public static final String PATH = "java/java-ionetwork/temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String str = "ABC\n가나다";

        Path path = Path.of(PATH);

        // 쓰기
        Files.writeString(path, str, UTF_8);

        // 읽기
        String readStr = Files.readString(path, UTF_8);
        System.out.println("readStr = " + readStr);
    }
}
