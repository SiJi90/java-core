package com.example.classloader;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author: slm
 */
public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        Color[] colors = new Color[]{Color.red, Color.blue, Color.white, Color.yellow, Color.green};
        frame.setSize(screenWidth, screenHeight);
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        //frame.setLayout(new GridBagLayout());
        AWTUtilities.setWindowOpaque(frame, false);
        int x = 0, y = 0;

        int i = 0;
        frame.setVisible(true);
        while (i < 1000) {
            i++;
            Thread.sleep(300);
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            //Thread.sleep(300);
            JLabel label = new JLabel();
            label.setForeground(Color.red);
            Font font = new Font("微软雅黑", Font.BOLD, 50);
            label.setFont(font);
            label.setText("233");
            if (x < screenWidth) {
                x += new Random().nextInt(screenWidth);

            } else {
                x -= new Random().nextInt(screenWidth);
            }
            if (y < screenHeight) {
                y += new Random().nextInt(screenHeight);
            } else {
                y -= new Random().nextInt(screenHeight);
            }
            x %= screenWidth;
            y %= screenHeight;
            label.setBounds(x, y, 100, 100);
            label.setForeground(colors[new Random().nextInt(5)]);
            label.setVisible(true);
            frame.add(label);
            frame.revalidate();
        }
    }
}
