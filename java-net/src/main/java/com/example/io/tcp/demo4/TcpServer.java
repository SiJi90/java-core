package com.example.io.tcp.demo4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/26
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("服务器已启动。。。");
        while (true) {
            Socket socket = server.accept();
            System.out.println(String.format("客户端[%s]已连接",socket.getRemoteSocketAddress()));
            print(socket);
        }
    }

    public static void print(Socket socket) {
        new Thread(() ->
        {
            InputStream is = null;
            try {
                is = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name());
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                System.out.println(s);
            }
        }).start();
    }
}
