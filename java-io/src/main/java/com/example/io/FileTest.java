package com.example.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class FileTest {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter("test.txt", StandardCharsets.UTF_8.toString()); InputStreamReader in = new InputStreamReader(System.in)) {
            char[] chars = new char[1024];
            int counter = 1;
            int len = 0;
            while (counter < 3 && (len = in.read(chars)) != -1) {
                counter++;
                System.out.println("counter = " + counter);
                out.write(chars, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
