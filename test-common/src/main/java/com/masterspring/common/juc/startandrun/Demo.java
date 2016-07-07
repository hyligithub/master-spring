package com.masterspring.common.juc.startandrun;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class Demo {
    public static void main(String[] args) {
        Thread thread = new MyThread("myThread");
        thread.run();

        thread.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}