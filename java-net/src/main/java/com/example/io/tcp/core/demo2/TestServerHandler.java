package com.example.io.tcp.core.demo2;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class TestServerHandler implements Runnable {

    private Socket incoming;

    private int counter;

    public TestServerHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try (OutputStream outputStream = incoming.getOutputStream(); PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true)) {
            while (counter < 100) {
                counter++;
                if (counter <= 10) {
                    out.println(counter);
                    Thread.sleep(100);
                }
            }

        } catch (Exception e) {

        }
    }
}
