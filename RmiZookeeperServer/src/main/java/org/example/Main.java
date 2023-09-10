package org.example;

import org.apache.zookeeper.*;
import org.example.service.UsersService;
import org.example.service.impl.UsersServiceimpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main implements Watcher {
    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            System.out.println("successfully connect to zookeeper");
        }
    }

    public static void main(String[] args) throws IOException, AlreadyBoundException, InterruptedException, KeeperException {
        UsersService usersService = new UsersServiceimpl();
        LocateRegistry.createRegistry(8888);
        String url ="rmi://192.168.2.17:8888/user";
        Naming.bind(url, usersService);
        //create znode to store url for rmi
        ZooKeeper zooKeeper = new ZooKeeper("192.168.2.17:2181", 150000, new Main());
        String path = zooKeeper.create("/user", url.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT );
        System.out.println(path);
    }
}