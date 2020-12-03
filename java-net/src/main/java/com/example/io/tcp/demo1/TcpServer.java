package com.example.io.tcp.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/25
 */
public class TcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("服务器启动完毕。。。");
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];

            int len = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, len));

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("收到，谢谢".getBytes());
            outputStream.flush();

            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
