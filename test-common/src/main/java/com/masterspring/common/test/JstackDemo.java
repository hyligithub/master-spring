package com.masterspring.common.test;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/6/20.
 */
public class JstackDemo {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new DeadLockClass(true));
        Thread thread2 = new Thread(new DeadLockClass(false));
        thread1.start();
        thread2.start();
    }
}

class DeadLockClass implements Runnable {
    private boolean flag = false;

    public DeadLockClass(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (Suo.object1) {
                    PrintUtil.print("o1" + Thread.currentThread().getName());
                    synchronized (Suo.object2) {
                        PrintUtil.print("o2" + Thread.currentThread().getName());
                    }
                }
            }
        } else {
            while (true) {
                synchronized (Suo.object2) {
                    PrintUtil.print("o2" + Thread.currentThread().getName());
                    synchronized (Suo.object1) {
                        PrintUtil.print("o1" + Thread.currentThread().getName());
                    }
                }
            }
        }
    }

}

class Suo {
    static Object object1 = new Object();
    static Object object2 = new Object();
}