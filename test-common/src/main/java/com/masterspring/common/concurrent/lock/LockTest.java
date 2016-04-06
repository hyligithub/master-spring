package com.masterspring.common.concurrent.lock;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

/**
 * Created by lihuiyan on 2016/4/5.
 */
public class LockTest {

    private static final int TIMES = 10;
    private static final int THREADS_NUM = 10;
    private static final int DEAL_TIMES = 100000;

    @Test
    public void testLock() throws InterruptedException {
        long costTime = 0;
        for (int i = 0; i < TIMES; i++) {
            long startTime = System.nanoTime();
            Thread[] threads = new Thread[THREADS_NUM];
            for (int j = 0; j < THREADS_NUM; j++) {
                threads[j] = new Thread() {
                    AtomicIntegerWithLock myAtomic = new AtomicIntegerWithLock();
                    @Override
                    public void run() {
                        for (int m = 0; m < DEAL_TIMES; m++) {
                            myAtomic.incrementAndGet();
                        }
                    }
                };
            }
            for (Thread ts : threads) {
                ts.start();
            }
            for (Thread ts : threads) {
                ts.join();
            }
            long endTime = System.nanoTime();
            costTime += endTime - startTime;
        }
        PrintUtil.print(costTime);
        costTime = 0;
    }
    @Test
    public void testSynchronized() throws InterruptedException {
        long costTime = 0;
        final Object lock = new Object();
        for (int i = 0; i < TIMES; i++) {
            long startTime = System.nanoTime();
            Thread[] threads = new Thread[THREADS_NUM];
            for (int j = 0; j < THREADS_NUM; j++) {
                threads[j] = new Thread() {
                    int value = 0;
                    @Override
                    public void run() {
                        for (int m = 0; m < DEAL_TIMES; m++) {
                            synchronized (lock) {
                                ++value;
                            }
                        }
                    }
                };
            }
            for (Thread ts : threads) {
                ts.start();
            }
            for (Thread ts : threads) {
                ts.join();
            }
            long endTime = System.nanoTime();
            costTime += endTime - startTime;
        }
        PrintUtil.print(costTime);
        costTime = 0;
    }
}
