package com.example.io.tcp.demo3;

import java.io.IOException;
import java.net.Socket;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/26
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);

    }
}
