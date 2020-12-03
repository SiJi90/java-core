package com.example.interfaces.call;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author: slm
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = e -> {};
        Timer timer = new Timer(1000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}
