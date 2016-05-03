package com.masterspring.common.demo.timer;

import java.util.ArrayList;

/**
 * Created by lihuiyan on 2016/3/11.
 */
public class ThreadAndRunnableExample {

    public static class MyThread extends Thread {
        private int tickets = 10;

        @Override
        public synchronized void run() {
            for (int i = 0; i < 20; i++) {
                while (tickets > 0) {
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + ":" + tickets);
                }
            }
        }
    }

    public static class MyRunnable implements Runnable {
        private int tickets = 10;

        public synchronized void run() {
            for (int i = 0; i < 20; i++) {
                while (tickets > 0) {
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + ":" + tickets);
                }
            }
        }
    }


    public static class MyRunnableThreadLocal implements Runnable {
        private static int num = 10;

        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        ArrayList<String> arrayList = new ArrayList<String>();

        public void run() {
            arrayList.add(Math.random() + "");
//            arrayList.add(num--);
//            threadLocal.set(num--);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ":" + arrayList.toString());
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        MyRunnableThreadLocal runnableThreadLocal = new MyRunnableThreadLocal();
        Thread thread1 = new Thread(runnableThreadLocal);
        Thread thread2 = new Thread(runnableThreadLocal);
        Thread thread3 = new Thread(runnableThreadLocal);
        thread1.start();
        thread2.start();
        thread3.start();

//        Thread thread1 = new Thread(myRunnable);
//        Thread thread2 = new Thread(myRunnable);
//        Thread thread3 = new Thread(myRunnable);
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }

}
