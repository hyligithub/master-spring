package com.masterspring.common.juc.jointest;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class JoinTest {
    public static void main(String[] args) {
        SubThread subThread = new SubThread("t1");
        System.out.println(Thread.currentThread().getName() + " begin");
        subThread.start();
        try {
            System.out.println(Thread.currentThread().getName() + " blocked");
            subThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}

class SubThread extends Thread {
    public SubThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};
