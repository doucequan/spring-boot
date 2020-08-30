package com.zhumj.zookeeper;


import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Main {


    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private static ZooKeeper zk  = null;

    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        String path = "/config";

        zk = new ZooKeeper("127.0.0.1:2181", 5000, event -> {
            if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {  //zk连接成功通知事件
                if (Watcher.Event.EventType.None == event.getType() && null == event.getPath()) {
                    connectedSemaphore.countDown();
                } else if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {  //zk目录节点数据变化通知事件
                    try {
                        System.out.println("配置已修改，新值为：" + new String(zk.getData(event.getPath(), true, stat)));
                    } catch (Exception e) {
                    }
                }

            }
        });

        connectedSemaphore.await();

        byte[] data = zk.getData(path, true, new Stat());

        System.out.println(new String(data));


        Thread.sleep(Integer.MAX_VALUE);

    }

}
