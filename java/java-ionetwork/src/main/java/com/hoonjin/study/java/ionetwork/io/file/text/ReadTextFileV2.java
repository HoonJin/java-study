package com.hoonjin.study.java.ionetwork.io.file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

    public static final String PATH = "java/java-ionetwork/temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String str = "ABC\n가나다";

        Path path = Path.of(PATH);

        // 쓰기
        Files.writeString(path, str, UTF_8);

        // 읽기
        List<String> lines = Files.readAllLines(path, UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }

        try (Stream<String> lineStream = Files.lines(path, UTF_8)) {
            lineStream.forEach(System.out::println);
        }
    }
}
