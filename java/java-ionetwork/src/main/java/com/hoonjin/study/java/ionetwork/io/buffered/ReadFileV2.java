package com.hoonjin.study.java.ionetwork.io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static com.hoonjin.study.java.ionetwork.io.buffered.BufferedConst.BUFFER_SIZE;
import static com.hoonjin.study.java.ionetwork.io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV2 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int size;
            while ((size = fis.read(buffer, 0, buffer.length)) != -1) {
                fileSize += size;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("File Created: " + FILE_NAME);
        System.out.println("File Size: " + fileSize + "byte");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
