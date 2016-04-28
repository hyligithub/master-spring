package com.masterspring.common.concurrent.synch;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/4/26.
 */
public class TestSync2 {
    public static void main(String[] args) {
        final TestSync2 testSync2 = new TestSync2();
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        testSync2.synMehtod();
                    }
                }
                , "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testSync2.notSyncMethod();
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                testSync2.synMehtod2();
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }


    public void synMehtod() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                PrintUtil.print(i + "--" + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void synMehtod2() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                PrintUtil.print(i + "--" + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void notSyncMethod() {
        for (int i = 0; i < 10; i++) {
            PrintUtil.print(i + "--" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
