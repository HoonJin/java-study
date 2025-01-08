package com.hoonjin.study.java.ionetwork.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {

    public static void main(String[] args) throws IOException {
        String file = "java/java-ionetwork/temp/hello.dat";
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = fis.readAllBytes();
            System.out.println(Arrays.toString(bytes));
        }
    }
}
