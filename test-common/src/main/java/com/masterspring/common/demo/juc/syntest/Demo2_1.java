package com.masterspring.common.demo.juc.syntest;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class Demo2_1 {
    public static void main(String[] args) {
        final Count count = new Count();
        Thread thread1 = new Thread(
                new Runnable() {
                    public void run() {
                        count.synMethod();
                    }
                }
                , "t1");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                count.noSynMethod();
            }
        }, "t2");
        thread1.start();
        thread2.start();
    }
}

class Count {
    public void synMethod() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " synMethod is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void noSynMethod() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " noSynMethod is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};