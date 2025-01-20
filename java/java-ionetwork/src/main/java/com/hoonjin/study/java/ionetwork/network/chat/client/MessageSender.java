package com.hoonjin.study.java.ionetwork.network.chat.client;

import com.hoonjin.study.java.ionetwork.network.chat.Command;
import lombok.RequiredArgsConstructor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class MessageSender implements Runnable {

    private static final String DELIMITER = "\\|";

    private final Socket socket;

    private boolean joined = false;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                log("input message with cmd: ");
                String msg = scanner.nextLine();
                if (msg.isEmpty()) {
                    continue;
                }
                String[] split = msg.split(DELIMITER);
                String cmd = split[0];

                if (Arrays.stream(Command.values()).noneMatch(c -> c.value().equals(cmd))) {
                    log("wrong command");
                    continue;
                }

                if (cmd.equals(Command.EXIT.value())) {
                    dos.writeUTF(msg);
                    joined = false;
                    break;
                } else if (cmd.equals(Command.JOIN.value())) {
                    joined = true;
                }

                if (joined) {
                    dos.writeUTF(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
