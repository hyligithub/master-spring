package com.masterspring.common.test;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lihuiyan on 2016/5/12.
 */
public class PerformanceTestTool {
    public long timecost(final int times, final Runnable task) {
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch overLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startLatch.await();
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        overLatch.countDown();
                    }

                }
            }).start();
        }
        long startTime = System.currentTimeMillis();
        startLatch.countDown();
        try {
            overLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    @Test
    public void testPerformance() {
        long costtime = this.timecost(5, new MyThread());
        PrintUtil.print(costtime);
    }

    class MyThread implements Runnable {

        @Override
        public void run() {
            PrintUtil.print(System.nanoTime() + Thread.currentThread().getName());
        }
    }

}
