package com.example.io.tcp.demo4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/26
 */
public class TcpClient {

    private static Boolean CONNECT_STATE = false;
    private static Socket socket = null;

    public static void main(String[] args) {

        connect();

        new Thread(() ->
        {

            while (true && CONNECT_STATE == true) {
                try {
                    Thread.sleep(5000);
                    socket.getOutputStream().write("心跳包机制\n".getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() ->
        {

            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reconnect();
            }
        }).start();


        while (true && CONNECT_STATE == true) {
            System.out.println("请输入发送信息：");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String msg = scanner.nextLine().trim();
                try {
                    OutputStream os = socket.getOutputStream();

                    os.write((msg + "\n").getBytes(StandardCharsets.UTF_8.name()));
                    os.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void connect() {
        try {
            socket = new Socket("127.0.0.1", 8000);
            System.out.println("服务器已连接");
            CONNECT_STATE = true;
        } catch (IOException e) {
            e.printStackTrace();
            CONNECT_STATE = false;
        }
    }

    public static void reconnect() {
        while (!CONNECT_STATE) {
            System.out.println("正在重新连接服务器");
            connect();
        }
    }


}
