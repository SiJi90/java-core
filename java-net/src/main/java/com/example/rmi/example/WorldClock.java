package com.example.rmi.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

/**
 * @author: slm
 */
public interface WorldClock extends Remote {

    LocalDateTime getLocalDateTime(String zoneId) throws RemoteException;
}
