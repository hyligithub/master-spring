package com.masterspring.common.juc.syntest;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class LockTest4 {
    Something4 x = new Something4();
    Something4 y = new Something4();

    public void test() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                x.isSynB();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                y.isSynA();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new LockTest4().test();
    }
}

class Something4 {
    public static synchronized void isSynA() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " static synchronized isSynA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void isSynB() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "  synchronized isSynB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};
