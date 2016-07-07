package com.masterspring.common.juc.priority;

/**
 * Created by lihuiyan on 2015/4/29.
 */
public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority());
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")" + " loop " + i);
        }
    }
}
