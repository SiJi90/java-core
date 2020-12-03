package com.example.interfaces.call;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author: slm
 */
public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is:" + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
