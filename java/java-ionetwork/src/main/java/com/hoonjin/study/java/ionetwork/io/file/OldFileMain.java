package com.hoonjin.study.java.ionetwork.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("java/java-ionetwork/temp/example.txt");
        File dir = new File("java/java-ionetwork/temp/exampleDir");

        System.out.println("file.exists() = " + file.exists());

        boolean created = file.createNewFile();

        boolean dirCreated = dir.mkdir();
        System.out.println("dirCreated = " + dirCreated);

//        boolean deleted = file.delete();
//        System.out.println("deleted = " + deleted);

        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("dir.isDirectory() = " + dir.isDirectory());

        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.length() = " + file.length() + "byte");

        File newFile = new File("java/java-ionetwork/temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("renamed = " + renamed);

        long lastModified = newFile.lastModified();
        System.out.println("newFile lastModified = " + new Date(lastModified));
    }
}
