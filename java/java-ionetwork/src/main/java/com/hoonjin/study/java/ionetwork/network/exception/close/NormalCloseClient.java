package com.hoonjin.study.java.ionetwork.network.exception.close;

import java.io.*;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

public class NormalCloseClient {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 12345)) {
            log("socket = " + socket);

            InputStream is = socket.getInputStream();
            readByInputStream(is);
            readByBufferedReader(is);
            readByDataInputStream(is);

            log("closed: " + socket.isClosed());
        }
    }

    private static void readByDataInputStream(InputStream is) {
        try (DataInputStream dis = new DataInputStream(is)) {
            String str = dis.readUTF();
            log("str = " + str);
        } catch (IOException e) {
            log(e);
        }
    }

    private static void readByBufferedReader(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = br.readLine();
        log("str = " + str);
        if (str == null) {
            is.close();
        }
    }

    private static void readByInputStream(InputStream is) throws IOException {
        int read = is.read();
        log("read = " + read);
        if (read == -1) {
            is.close();
        }
    }
}
