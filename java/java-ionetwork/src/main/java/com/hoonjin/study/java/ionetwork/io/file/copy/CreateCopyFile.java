package com.hoonjin.study.java.ionetwork.io.file.copy;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateCopyFile {

    private static final int FILE_SIZE = 200 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        String filename = "java/java-ionetwork/temp/copy.dat";

        long startTime = System.currentTimeMillis();

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            byte[] buffer = new byte[FILE_SIZE];
            fos.write(buffer);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
