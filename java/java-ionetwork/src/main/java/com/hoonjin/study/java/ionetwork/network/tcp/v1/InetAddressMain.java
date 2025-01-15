package com.hoonjin.study.java.ionetwork.network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println("localhost = " + localhost);

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println("google = " + google);

        // 1. /etc/hosts 를 먼저 확인한다.
        // 2. DNS 서버에 요청해서 확인
    }
}
