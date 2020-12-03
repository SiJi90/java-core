package com.example.io.tcp.core.demo1;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class ThreadServerSocketTest {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket()) {
            server.bind(new InetSocketAddress(9000));
            System.out.println("服务器已启动");
            int i = 0;
            while (true) {
                Socket incoming = server.accept();
                i++;
                System.out.println("spawning: " + i);
                Runnable runnable = new ThreadedEchoHandler(incoming);
                Thread thread = new Thread(runnable);
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class ThreadedEchoHandler implements Runnable {


    private Socket incoming;

    public ThreadedEchoHandler() {

    }

    public ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try (InputStream inputStream = incoming.getInputStream(); OutputStream outputStream = incoming.getOutputStream()) {
            Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8.toString());
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
            out.println("Hello, Enter Bye To Exit!");

            // 半关闭，关闭套接字的输出流（将输出流设置为 “流结束”）
            //incoming.shutdownOutput();
            // 半关闭，关闭套接字的输入流（将输入流设置为 “流结束”）
            incoming.shutdownInput();
            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(incoming.getRemoteSocketAddress() + "Echo： " + line);
                if (line.trim().equals("Bye")) {
                    done = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
