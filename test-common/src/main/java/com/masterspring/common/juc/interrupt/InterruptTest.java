package com.masterspring.common.juc.interrupt;

/**
 * Created by lihuiyan on 2015/4/29.
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread thread = new MyThread("t1");
        System.out.println(thread.getName() + " status :" + (thread.getState()));
        thread.start();
        System.out.println(thread.getName() + " status :" + (thread.getState()));

        try {
            Thread.sleep(300);//���߳�����3ms
            thread.interrupt();//�ж�t1
            System.out.println(thread.getName() + " status :" + (thread.getState()));
            Thread.sleep(300);
            System.out.println(thread.getName() + " status :" + (thread.getState()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        int i = 0;
        try {
            while (!isInterrupted()) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + (this.getState()) + " loop " + i++);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + (this.getState()) + " throw InterruptedException ");
        }
    }
}