package com.hoonjin.study.java.ionetwork.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {

    private static final int BUFFER_SIZE = 10;

    public static void main(String[] args) throws IOException {
        String file = "java/java-ionetwork/temp/hello.dat";

        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] input = {65, 66, 67, 68, 65, 66, 67, 68, 65, 66, 67, 68};
            fos.write(input);
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int readCnt;
            while ((readCnt = fis.read(buffer, 0, BUFFER_SIZE)) != -1) {
                System.out.println("readCnt = " + readCnt);
                String data = Arrays.toString(buffer);
                System.out.println(data);
                buffer = new byte[BUFFER_SIZE];
            }
        }
    }
}
