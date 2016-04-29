package com.masterspring.common.demo.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lihuiyan on 2015/5/6.
 */
class CountDownLatchTest {
    private static int LATCH_SIZE = 5;

    public static void main(String[] args) {

        try {
            CountDownLatch countDownLatch = new CountDownLatch(LATCH_SIZE);
            for (int i = 0; i < LATCH_SIZE; i++) {
                new ThreadA(countDownLatch).start();
            }
            System.out.println(Thread.currentThread().getName() + "main wait begin");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "continue");
    }
}

class ThreadA extends Thread {

    private CountDownLatch countDownLatch;

    public ThreadA(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
            countDownLatch.countDown();
            System.out.println(countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
};
