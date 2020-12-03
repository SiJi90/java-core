package com.example.swing.simpleframe;

import javax.swing.*;
import java.awt.*;

/**
 * @author: slm
 */
public class SimpleFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setUndecorated(true);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) screenSize.getWidth();
            int height = (int) screenSize.getHeight();
            System.out.println("height = " + height);
            System.out.println("width = " + width);
            frame.setBounds((width - 500) / 2, (height - 200) / 2, 500, 200);

            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 300;

    public static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        String path = this.getClass().getClassLoader().getResource("qq.jpg").getPath();
        Image image = new ImageIcon(path).getImage();
        setIconImage(image);
        setResizable(false);
        setTitle("山寨QQ");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(new NotHelloWorldComponent());
        pack();
    }
}

class NotHelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;


    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
        g.setColor(Color.red);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}