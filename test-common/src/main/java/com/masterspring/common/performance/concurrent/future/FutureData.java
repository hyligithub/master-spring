package com.masterspring.common.performance.concurrent.future;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by lihuiyan on 2016/2/16.
 */
public class FutureData implements Data {

    private AtomicBoolean isReady = new AtomicBoolean(false);

    private String realData;

    private RealData rd = null;

    protected synchronized void setRealData(RealData realData) {
        if (isReady.get()) {
            System.out.println("realData is Ok ");
            return;
        }
        rd = realData;
        isReady.set(true);
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while (!isReady.get()) {
            try {
                System.out.println("realData is not OK");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return rd.getResult();
    }
}
