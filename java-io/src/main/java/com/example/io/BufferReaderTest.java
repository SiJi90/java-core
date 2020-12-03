package com.example.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/29
 */
public class BufferReaderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        InputStreamReader in = new InputStreamReader(System.in, StandardCharsets.UTF_8.toString());
        try (BufferedReader reader = new BufferedReader(in)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("echo: " + line);
                if (line.contains("exit")) {
                    System.out.println("满足你的要求，我退出。。。");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
