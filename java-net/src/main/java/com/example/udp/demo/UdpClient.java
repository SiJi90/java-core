package com.example.udp.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author: slm
 */
public class UdpClient {

    public static void main(String[] args) {
        start(8000);
    }

    public static void start(int port) {
        try {
            DatagramSocket ds = new DatagramSocket();
            ds.connect(new InetSocketAddress("localhost", port));
            ds.setSoTimeout(1000);
            // 发送
            byte[] data = "数据".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length);
            ds.send(packet);

            // 接收
            byte[] bytes = new byte[1024];
            packet = new DatagramPacket(bytes, bytes.length);
            ds.receive(packet);
            String resp = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            System.out.println("接收到数据:" + resp);
            //ds.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
