package com.hoonjin.study.java.ionetwork.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {
        String file = "java/java-ionetwork/temp/hello.dat";
        FileOutputStream fos = new FileOutputStream(file, false);
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read()); // -1 EOF
            System.out.println(fis.read()); // -1
        }
    }
}
