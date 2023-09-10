package org.example.service.impl;

import org.example.service.UsersService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UsersServiceimpl extends UnicastRemoteObject implements UsersService {
    public UsersServiceimpl() throws RemoteException {
        super();
    }

    public String findUser(String str) throws RemoteException {
        return "Hello zookeeper" + str;
    }
}
