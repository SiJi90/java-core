package com.example.rmi.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author: slm
 */
public class Server {
    public static void main(String[] args) throws RemoteException {
        System.out.println("create World Clock remote service");

        // 实例化
        WorldClock worldClock = new WorldClockService();

        // 将服务转化为远程接口
        WorldClock skeleton = (WorldClock) UnicastRemoteObject.exportObject(worldClock, 0);

        // 将 Rmi 服务注册到 1099 端口
        Registry registry = LocateRegistry.createRegistry(1099);

        // 注册此服务, 服务名未 WorldClock
        registry.rebind(WorldClock.class.getName(), skeleton);
    }
}
