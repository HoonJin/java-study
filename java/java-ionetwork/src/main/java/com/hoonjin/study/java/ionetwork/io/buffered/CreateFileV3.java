package com.hoonjin.study.java.ionetwork.io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.hoonjin.study.java.ionetwork.io.buffered.BufferedConst.*;

public class CreateFileV3 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE)) {
            for (int i = 0; i < FILE_SIZE; i++) {
                bos.write(1);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("File Created: " + FILE_NAME);
        System.out.println("File Size: " + FILE_SIZE + "byte");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
