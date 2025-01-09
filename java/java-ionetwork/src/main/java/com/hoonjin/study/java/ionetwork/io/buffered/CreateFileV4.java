package com.hoonjin.study.java.ionetwork.io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.hoonjin.study.java.ionetwork.io.buffered.BufferedConst.FILE_NAME;
import static com.hoonjin.study.java.ionetwork.io.buffered.BufferedConst.FILE_SIZE;

public class CreateFileV4 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            byte[] buffer = new byte[FILE_SIZE];
            for (int i = 0; i < FILE_SIZE; i++) {
                buffer[i] = 1;
            }
            fos.write(buffer);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("File Created: " + FILE_NAME);
        System.out.println("File Size: " + FILE_SIZE + "byte");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
