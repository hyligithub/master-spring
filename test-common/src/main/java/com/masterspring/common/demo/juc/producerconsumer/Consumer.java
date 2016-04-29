package com.masterspring.common.demo.juc.producerconsumer;

/**
 * Created by lihuiyan on 2015/4/29.
 */
public class Consumer {
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consumer(final int val) {
        new Thread() {
            public void run() {
                depot.consumer(val);
            }
        }.start();
    }
}
