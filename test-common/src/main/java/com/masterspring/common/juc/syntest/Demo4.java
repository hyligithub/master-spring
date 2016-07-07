package com.masterspring.common.juc.syntest;

import java.util.Random;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class Demo4 {
    public synchronized void synMethod() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void synBlock() {
        Random random = new Random();
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        long startTime = System.currentTimeMillis();
        demo4.synBlock();
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;

//        long startTime1 = System.currentTimeMillis();
//        demo4.synBlock();
//        long endTime1 = System.currentTimeMillis();
//        long interval1 = endTime1 - startTime1;

        System.out.println(interval + "---");

    }
}
