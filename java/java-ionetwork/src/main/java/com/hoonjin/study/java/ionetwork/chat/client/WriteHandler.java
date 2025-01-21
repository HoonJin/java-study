package com.hoonjin.study.java.ionetwork.chat.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class WriteHandler implements Runnable {

    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;

    @Getter
    private boolean closed = false;

    @Override
    public void run() {
        log("start writeHandler");
        Scanner scanner = new Scanner(System.in);
        try {
            String username = inputUsername(scanner);
            output.writeUTF("/join" + DELIMITER + username);

            while (true) {
                String toSend = scanner.nextLine();
                if (toSend.isEmpty()) {
                    continue;
                }

                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                // "/"로 시작하면 명령어, 나머지는 일반 메시지
                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                    continue;
                }

                output.writeUTF("/message" + DELIMITER + toSend);
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private static String inputUsername(Scanner scanner) {
        log("이름을 입력하세요: ");
        String username;
        do {
            username = scanner.nextLine();
        } while (username.isEmpty());
        return username;
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        try {
            System.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        closed = true;
        log("closed WriteHandler");
    }
}
