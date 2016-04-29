package com.masterspring.common.demo.juc.yieldtest;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class YieldTest {
    private static Object object = new Object();

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA("t1");
        ThreadA threadB = new ThreadA("t2");
        threadA.start();
        threadB.start();
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            synchronized (object) {//yield�����ͷ���
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    if (i % 4 == 0) {
                        Thread.yield();
                    }
                }
            }
        }
    }
}

