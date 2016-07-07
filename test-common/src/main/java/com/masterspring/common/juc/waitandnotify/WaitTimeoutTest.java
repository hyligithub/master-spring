package com.masterspring.common.juc.waitandnotify;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class WaitTimeoutTest {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA("threadA");
        synchronized (threadA) {
            System.out.println(Thread.currentThread().getName() + " start threadA ");
            threadA.start();
            try {
                System.out.println(Thread.currentThread().getName() + " wait threadA ");
                threadA.wait(3000);
                System.out.println(Thread.currentThread().getName() + " continue ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    public void run() {
//        synchronized (this) {//����������������
//            System.out.println(Thread.currentThread().getName()+" call notify ");
            //��ѭ��
            while (true) ;
//        }
    }
}