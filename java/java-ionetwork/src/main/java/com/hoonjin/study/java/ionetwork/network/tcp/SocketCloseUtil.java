package com.hoonjin.study.java.ionetwork.network.tcp;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

public class SocketCloseUtil {

    public static void closeAll(Socket socket, InputStream ips, OutputStream ops) {
        close(ips);
        close(ops);
        // ips, ops는 순서가 상관없으나, socket을 가장 마지막에 닫아야 한다
        close(socket);
    }

    public static void close(Closeable socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

//    public static void close(OutputStream ops) {
//        if (ops != null) {
//            try {
//                ops.close();
//            } catch (IOException e) {
//                log(e.getMessage());
//            }
//        }
//    }
//
//    public static void close(InputStream ips) {
//        if (ips != null) {
//            try {
//                ips.close();
//            } catch (IOException e) {
//                log(e.getMessage());
//            }
//        }
//    }
//
//    public static void close(Socket socket) {
//        if (socket != null) {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                log(e.getMessage());
//            }
//        }
//    }
}
