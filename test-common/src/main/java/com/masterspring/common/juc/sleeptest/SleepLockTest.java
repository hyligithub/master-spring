package com.masterspring.common.juc.sleeptest;

/**
 * Created by lihuiyan on 2015/4/28.
 *
 * sleep �����ͷ���
 */
public class SleepLockTest {

    public static void main(String[] args) {
        Object object = new Object();
        ThreadA t1 = new ThreadA("t1", object);
        ThreadA t2 = new ThreadA("t2", object);
        t1.start();
        t2.start();
    }

    static class ThreadA extends Thread {
        private Object object;

        public ThreadA(String name, Object o) {
            super(name);
            this.object = o;
        }

        public void run() {
            synchronized (object) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName() + "--" + this.getPriority() + "--" + i);
                    if (i % 4 == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
