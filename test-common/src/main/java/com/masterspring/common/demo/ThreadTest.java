package com.masterspring.common.demo;

/**
 * Created by lihuiyan on 2015/11/12.
 */
public class ThreadTest extends Thread {
    public int num;

    public ThreadTest(int num) {
        this.num = num;
    }

    private static Object object = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new ThreadTest(i).start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        abc();
    }

    public static synchronized void abc() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName() + "-->" + i);
        }
    }
}
