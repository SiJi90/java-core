package com.example.io.tcp.core.demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class TestServerSocket {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            try (Socket incoming = server.accept()) {
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try (Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8.toString())) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
                    out.println("Hello 小胖子.");

                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("echo: " + line);
                        if (line.trim().equals("Bye")) {
                            done = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
