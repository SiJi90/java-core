package com.example.io.tcp.core.demo1;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class SocketTest {
    public static void main(String[] args) {
        try (Socket socket = new Socket("time-a.nist.gov", 13); Scanner scanner = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8.toString())) {
            // 设置超时时间为 10 s
            socket.setSoTimeout(10000);
            socket.connect(new InetSocketAddress("time-a.nist.gov", 10000));
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                System.out.println("line = " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
