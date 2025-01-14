package com.hoonjin.study.java.ionetwork.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class newFilesPath {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("java/java-ionetwork/temp/..");
        System.out.println("path = " + path);

        // 절대경로
        System.out.println("path.toAbsolutePath() = " + path.toAbsolutePath());
        // 정규경로
        System.out.println("path.toRealPath() = " + path.toRealPath());

        try (Stream<Path> pathStream = Files.list(path)) {
            pathStream.forEach(p -> System.out.println((Files.isRegularFile(p) ? "F" : "D") + "|" + p.getFileName()));
        }

    }
}
