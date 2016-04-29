package com.masterspring.common.demo.juc.syntest;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class LockTest3 {
    Something3 x = new Something3();
    Something3 y = new Something3();

    public void test() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                x.isSynA();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                y.isSynB();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new LockTest3().test();
    }
}

class Something3 {
    public static synchronized void isSynA() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " isSynA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void isSynB() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " isSynB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}