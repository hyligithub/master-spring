package com.masterspring.common.demo.juc.waitandnotify;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class WaitTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("myThread");
        //
        synchronized (myThread) {
            //�߳�myThread����
            System.out.println(Thread.currentThread().getName() + " start myThread");
            myThread.start();
            try { // ���̵߳ȴ�t1ͨ��notify()���ѡ�
                System.out.println(Thread.currentThread().getName() + " wait()");
                myThread.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify");
            notify();
        }
    }
};