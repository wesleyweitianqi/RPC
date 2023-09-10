package org.example.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UsersService extends Remote {
    String findUser(String str) throws RemoteException;
}
