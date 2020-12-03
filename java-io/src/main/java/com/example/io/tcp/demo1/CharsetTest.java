package com.example.io.tcp.demo1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/29
 */
public class CharsetTest {
    public static void main(String[] args) {
        System.out.println("Charset.defaultCharset() = " + Charset.defaultCharset());
        final String fileName = "employee.dat";
        try (DataInputStream in = new DataInputStream(new FileInputStream(fileName));) {

            String line = null;
            byte[] bytes = new byte[1024];
            int len = 0;

            while ((len = in.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
