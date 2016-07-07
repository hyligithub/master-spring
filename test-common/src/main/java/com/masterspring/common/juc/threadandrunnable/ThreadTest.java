package com.masterspring.common.juc.threadandrunnable;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();
//        thread1.start();
//        thread2.start();
//        thread3.start();
        MyRunnable myRunnable = new MyRunnable();
        Thread r1 = new Thread(myRunnable);
        Thread r2 = new Thread(myRunnable);
        r1.start();
        r2.start();
    }
}

class MyThread extends Thread {
    private int ticket = 10;

    public void run() {
        for (int i = 0; i < 20; i++) {
            if (ticket > 0) {
                System.out.println(this.getName() + "卖票 ticket:" + ticket--);
            }
        }
    }
};

class MyRunnable implements Runnable {

    private volatile int ticket = 10;

    public synchronized void run() {
        for (int i = 0; i < 20; i++) {
            if (ticket > 0) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票ticket:" + ticket--);
            }
        }
    }
};