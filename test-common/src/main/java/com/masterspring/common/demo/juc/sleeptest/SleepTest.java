package com.masterspring.common.demo.juc.sleeptest;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class SleepTest {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA("t1");
        threadA.start();
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                if (i % 4 == 0) {
                    try {
                        System.out.println(this.getName() + this.getPriority() + i);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
