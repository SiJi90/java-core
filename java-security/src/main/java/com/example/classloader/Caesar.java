package com.example.classloader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: slm
 */
public class Caesar {

    public static void main(String[] args) {
        /*if (args.length != 3) {
            System.out.println("USAGE: java classLoader.Caesar in out key");
            return;
        }*/
        encrypt();
    }

    public static void encrypt() {
        try (FileInputStream in = new FileInputStream("out.txt"); FileOutputStream out = new FileOutputStream("out_.txt")) {
            int key = Integer.parseInt("3");
            int ch;
            while ((ch = in.read()) != -1) {
                byte c = (byte) (ch - key);
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
