package com.hoonjin.study.java.ionetwork.io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class newFilesMain {

    public static void main(String[] args) throws IOException {
        Path file = Path.of("java/java-ionetwork/temp/example.txt");
        Path dir = Path.of("java/java-ionetwork/temp/exampleDir");

        System.out.println("Files.exists(file) = " + Files.exists(file));

        try {
            System.out.println("Files.createFile(file) = " + Files.createFile(file));
        } catch (FileAlreadyExistsException e) {
            System.out.println("file is already created");
        }

        try {
            System.out.println("Files.createDirectory(dir) = " + Files.createDirectory(dir));
        } catch (FileAlreadyExistsException e) {
            System.out.println("directory is already created");
        }

//        Files.delete(file);
//        System.out.println("Files.delete(file) = ");

        System.out.println("Files.isRegularFile(file) = " + Files.isRegularFile(file));
        System.out.println("Files.isDirectory(dir) = " + Files.isDirectory(dir));
        System.out.println("file.getFileName() = " + file.getFileName());
        System.out.println("Files.size(file) = " + Files.size(file));

        Path newFile = Path.of("java/java-ionetwork/temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("file renamed");

        System.out.println("Files.getLastModifiedTime(newFile) = " + Files.getLastModifiedTime(newFile));

        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("===== attrs =====");
        System.out.println("attrs.creationTime() = " + attrs.creationTime());
        System.out.println("attrs.isRegularFile() = " + attrs.isRegularFile());
        System.out.println("attrs.fileKey() = " + attrs.fileKey());
        System.out.println("attrs.isSymbolicLink() = " + attrs.isSymbolicLink());
        System.out.println("attrs.size() = " + attrs.size());
    }
}
