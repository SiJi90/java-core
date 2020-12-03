package com.example.rmi.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

/**
 * @author: slm
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 连接服务器
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        WorldClock worldClock = (WorldClock) registry.lookup(WorldClock.class.getName());

        LocalDateTime now = worldClock.getLocalDateTime("Asia/Shanghai");
        System.out.println("now = " + now);
    }
}
