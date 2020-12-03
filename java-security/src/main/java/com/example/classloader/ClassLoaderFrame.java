package com.example.classloader;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;

/**
 * @author: slm
 */
public class ClassLoaderFrame extends JFrame {

    private JTextField keyField = new JTextField("3", 4);
    private JTextField nameField = new JTextField("Calculator", 30);
    private static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public ClassLoaderFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new GridBagLayout());
        add(new JLabel("Class"));
        add(nameField);
        add(new JLabel("Key"));
        add(keyField);
        JButton button = new JButton("Load");
        add(button);
        button.addActionListener(e -> runClass(nameField.getText(), keyField.getText()));
        pack();
    }

    public void runClass(String name, String key) {
        try {
            CyptoClassLoader loader = new CyptoClassLoader(Integer.parseInt(key));
            Class<?> c = loader.loadClass(name);
            Method method = c.getMethod("main", String[].class);
            method.invoke(null, (Object) new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
    }
}
