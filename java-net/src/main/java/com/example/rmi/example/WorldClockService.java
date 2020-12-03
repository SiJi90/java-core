package com.example.rmi.example;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author: slm
 */
public class WorldClockService implements WorldClock {
    @Override
    public LocalDateTime getLocalDateTime(String zoneId) throws RemoteException {
        System.out.println("接收到客户端调用");
        return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
    }
}
