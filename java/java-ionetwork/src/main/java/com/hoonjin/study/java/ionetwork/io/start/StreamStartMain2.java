package com.hoonjin.study.java.ionetwork.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2 {

    public static void main(String[] args) throws IOException {
        String file = "java/java-ionetwork/temp/hello.dat";
        FileOutputStream fos = new FileOutputStream(file, true); // 기존 파일이 있으면 뒤에 추가한다.
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        try (FileInputStream fis = new FileInputStream(file)) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.println(data);
            }
        }
    }
}
