package com.masterspring.common.test;

import com.masterspring.common.PrintUtil;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by lihuiyan on 2016/5/12.
 */
public class BankWaterService implements Runnable {

    final CyclicBarrier c = new CyclicBarrier(4, this);
    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(4);
    Executor executor = Executors.newFixedThreadPool(4);

    public void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    map.put(Thread.currentThread().getName(), 1);
                    try {
                        int index = c.await();
                        PrintUtil.print(index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } finally {
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : map.entrySet()) {
            result += sheet.getValue();
        }
        PrintUtil.print(result);
    }
}
