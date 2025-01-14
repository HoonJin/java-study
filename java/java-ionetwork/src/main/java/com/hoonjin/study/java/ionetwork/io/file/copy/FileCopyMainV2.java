package com.hoonjin.study.java.ionetwork.io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV2 {

    private static final String DIR = "java/java-ionetwork/temp";

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(DIR + "/copy.dat");
             FileOutputStream fos = new FileOutputStream(DIR + "/copy_new.dat")) {
            fis.transferTo(fos);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
