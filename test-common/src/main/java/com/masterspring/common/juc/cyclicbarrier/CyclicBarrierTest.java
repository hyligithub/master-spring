package com.masterspring.common.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lihuiyan on 2015/5/6.
 */
public class CyclicBarrierTest {
    private static int PARTIES_SIZE = 5;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(PARTIES_SIZE, new Runnable() {
            @Override
            public void run() {
                System.out.println("all parties is ok");
            }
        });
        for (int i = 0; i < PARTIES_SIZE; i++) {
            new ThreadA("thread" + i).start();
        }

    }

    static class ThreadA extends Thread {
        private String name;

        public ThreadA(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println(name + " wait begin");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + " continue");
        }
    }
}
