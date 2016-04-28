package com.masterspring.common.concurrent.latch;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lihuiyan on 2016/4/6.
 */
public class CountDownLatchTest {

    @Test
    public void testPerformance() throws InterruptedException {
        final int times = 10;
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch overLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        startLatch.await();
                        System.out.println("sss");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    } finally {
                        overLatch.countDown();
                    }
                }
            }).start();
        }
        //
        long start = System.nanoTime();
        startLatch.countDown();
        overLatch.await();
        long ss = System.nanoTime() - start;
        PrintUtil.print(ss);
    }
}
