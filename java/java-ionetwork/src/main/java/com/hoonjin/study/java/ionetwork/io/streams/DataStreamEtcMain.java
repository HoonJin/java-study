package com.hoonjin.study.java.ionetwork.io.streams;

import java.io.*;

public class DataStreamEtcMain {

    static final String PATH = "java/java-ionetwork/temp/data.dat";

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(PATH);
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("회원1");
        dos.writeInt(20);
        dos.writeDouble(10.5);
        dos.writeBoolean(true);

        dos.close();

        FileInputStream fis = new FileInputStream(PATH);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());

        dis.close();
    }
}
