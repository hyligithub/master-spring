package com.masterspring.common.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lihuiyan on 2016/4/2.
 */
public class NoSynchronizedCounter {
    private AtomicInteger value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (!value.compareAndSet(v, v + 1));
        return v + 1;
    }
}
