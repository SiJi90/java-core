package com.example.io.tcp.core.demo2;

import javax.swing.*;
import java.util.Scanner;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class InterruptibleSocketFrame extends JFrame {

    private Scanner in;
    private JButton interruptibleButton;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea messages;
    private TestServer server;
}
