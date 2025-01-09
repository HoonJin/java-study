package com.hoonjin.study.java.ionetwork.io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.hoonjin.study.java.ionetwork.io.buffered.BufferedConst.*;

public class CreateFileV2 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bufferIndex = 0;
            for (int i = 0; i < FILE_SIZE; i++) {
                buffer[bufferIndex++] = 1;

                if (bufferIndex == BUFFER_SIZE) {
                    fos.write(buffer);
                    bufferIndex = 0;
                }
            }

            if (bufferIndex > 0) {
                fos.write(buffer, 0, bufferIndex);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("File Created: " + FILE_NAME);
        System.out.println("File Size: " + FILE_SIZE + "byte");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
