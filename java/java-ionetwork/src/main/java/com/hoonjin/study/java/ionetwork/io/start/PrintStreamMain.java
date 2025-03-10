package com.hoonjin.study.java.ionetwork.io.start;

import java.io.IOException;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;

        byte[] bytes = "Hello\n".getBytes(UTF_8);
        ps.write(bytes);

        // same as
        ps.println("Hello");
    }
}
