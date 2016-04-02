package com.masterspring.common.concurrent.cas;

/**
 * Created by lihuiyan on 2016/4/2.
 */
public class Counter {
    private int value = 0;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void increment() {
        value = value + 1;
    }
}
