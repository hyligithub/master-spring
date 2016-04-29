package com.masterspring.common.demo.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by lihuiyan on 2015/5/6.
 */
public class LockSupportTest {
    private static Thread mainThread;

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA("ta");
        System.out.println(Thread.currentThread().getName() + " start ta");
        threadA.start();
        mainThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " lock ");
        LockSupport.park(mainThread);//���߳�����
        System.out.println(Thread.currentThread().getName() + " continue ");
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(this.getName() + " runnable");
            System.out.println(Thread.currentThread().getName() + " wakup others");
            LockSupport.unpark(mainThread);//�������߳�
        }
    }
}
