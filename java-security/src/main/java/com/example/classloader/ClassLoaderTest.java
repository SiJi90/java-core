package com.example.classloader;

import javax.swing.*;
import java.awt.*;

/**
 * @author: slm
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ClassLoaderFrame();
            frame.setTitle("ClassLoaderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
