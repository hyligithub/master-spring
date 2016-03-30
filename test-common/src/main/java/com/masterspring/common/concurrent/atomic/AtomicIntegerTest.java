package com.masterspring.common.concurrent.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lihuiyan on 2016/3/30.
 */
public class AtomicIntegerTest {

    @Test
    public void testAll() throws InterruptedException {
        final AtomicInteger value = new AtomicInteger(10);
        Assert.assertEquals(value.compareAndSet(1, 2), false);
        Assert.assertEquals(value.get(), 10);
        Assert.assertTrue(value.compareAndSet(10, 3));
        Assert.assertEquals(value.get(), 3);
        value.set(0);

        //
        Assert.assertEquals(value.incrementAndGet(), 1);
        Assert.assertEquals(value.getAndAdd(2), 1);
        Assert.assertEquals(value.getAndSet(5), 3);
        Assert.assertEquals(value.get(), 5);

        final int threadSize = 10;
        Thread[] threads = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    value.incrementAndGet();
                }
            };
        }
        for(Thread thread:threads){
            thread.start();
        }
        Thread.sleep(1000);
//        for(Thread thread:threads){
//            thread.join();
//        }

        Assert.assertEquals(value.get(),5+threadSize);
    }
}
