package org.example;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.example.service.UsersService;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Main implements Watcher {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException, NotBoundException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.2.17:2181", 150000, new Main());
        byte[] data = zooKeeper.getData("/user", new Main(), new Stat());
        String url = new String(data);
        UsersService usersService =(UsersService) Naming.lookup(url);
        String result = usersService.findUser("hello Jenny");
        System.out.println(result);
    }

    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("connected");
        }
    }

}