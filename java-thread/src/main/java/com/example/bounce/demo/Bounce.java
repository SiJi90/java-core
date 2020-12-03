package com.example.bounce.demo;

import javax.swing.*;
import java.awt.*;

/**
 * @author: slm
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
