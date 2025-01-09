package com.hoonjin.study.java.ionetwork.io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static com.hoonjin.study.java.ionetwork.io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV4 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        int fileSize;
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            byte[] bytes = fis.readAllBytes();
            fileSize = bytes.length;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("File Created: " + FILE_NAME);
        System.out.println("File Size: " + fileSize + "byte");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
