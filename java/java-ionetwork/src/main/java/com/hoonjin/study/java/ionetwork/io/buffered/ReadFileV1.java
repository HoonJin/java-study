package com.hoonjin.study.java.ionetwork.io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static com.hoonjin.study.java.ionetwork.io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV1 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            int data;
            while ((data = fis.read()) != -1) {
                fileSize++;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("File Created: " + FILE_NAME);
        System.out.println("File Size: " + fileSize + "byte");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
