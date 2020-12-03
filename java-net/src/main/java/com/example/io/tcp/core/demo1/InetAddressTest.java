package com.example.io.tcp.core.demo1;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class InetAddressTest {
    public static void main(String[] args) {
        assert args.length > 0;
        String host = args[0];

    }

    @Test
    public void test01() {
        try {
            System.out.println(InetAddress.getLocalHost());
            final InetAddress[] addresses = InetAddress.getAllByName("google.com");
            for (InetAddress address : addresses) {
                System.out.println("address = " + address);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
