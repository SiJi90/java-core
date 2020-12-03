package com.example.udp.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

/**
 * @author: slm
 */
public class UdpServer {
    public static void main(String[] args) {
        start(8000);
    }

    public static void start(int port) {

        try {
            DatagramSocket ds = new DatagramSocket(port);
            for (; ; ) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                ds.receive(packet);
                String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
                System.out.println(String.format("接收到数据: %s", s));
                byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
                System.out.println(packet.getSocketAddress());
                packet.setData(data);
                ds.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
