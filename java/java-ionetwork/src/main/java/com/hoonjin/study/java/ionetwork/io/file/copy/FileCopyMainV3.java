package com.hoonjin.study.java.ionetwork.io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyMainV3 {

    private static final String DIR = "java/java-ionetwork/temp";

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        Path source = Path.of(DIR + "/copy.dat");
        Path target = Path.of(DIR + "/copy_new.dat");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
