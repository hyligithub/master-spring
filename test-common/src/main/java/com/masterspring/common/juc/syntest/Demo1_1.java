package com.masterspring.common.juc.syntest;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class Demo1_1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable {

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
};