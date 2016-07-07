package com.masterspring.common.juc.concurrenthashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lihuiyan on 2015/5/9.
 */
public class ConcurrentHashMapTest {

    static Map map = new ConcurrentHashMap();//��hashmap�ͻ�������

    public static void main(String[] args) {
        Thread t1 = new MyThread("t1", map);
        Thread t2 = new MyThread("t2", map);
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    private String name;
    private Map map;

    public MyThread(String name, Map map) {
        super(name);
        this.map = map;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
            printALL(map);
        }
    }

    private void printALL(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
