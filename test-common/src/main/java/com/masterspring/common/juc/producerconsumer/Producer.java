package com.masterspring.common.juc.producerconsumer;

/**
 * Created by lihuiyan on 2015/4/29.
 */
public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void producer(final int val) {
        new Thread() {
            public void run() {
                depot.producer(val);
            }
        }.start();
    }

}
