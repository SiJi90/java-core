package com.example.io.tcp.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/25
 */
public class TcpClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("你好，服务器".getBytes());
            InputStream inputStream = socket.getInputStream();

            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, len));

            outputStream.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
