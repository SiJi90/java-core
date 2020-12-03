package com.example.bounce.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author: slm
 */
public class BounceFrame extends JFrame {
    private BallComponent component;

    public static final int STEPS = 10 * 1000;
    public static final int DELAY = 3;

    public BounceFrame() {
        setTitle("Bounce");
        component = new BallComponent();
        add(component, BorderLayout.CENTER);

        JPanel button = new JPanel();
        addButton(button, "Start", event -> addBall());
        addButton(button, "Close", e -> System.exit(0));
        add(button, BorderLayout.SOUTH);
        pack();
    }


    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        try {
            Ball ball = new Ball();
            component.add(ball);

            for (int i = 0; i < STEPS; i++) {
                ball.move(component.getBounds());
                component.paint(component.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
