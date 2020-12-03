package com.example.io.tcp.core.demo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class TestServer implements Runnable {
    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(8189)) {
            while (true) {
                Socket incoming = server.accept();
               Runnable r =  new TestServerHandler(incoming);
               new Thread(r).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
