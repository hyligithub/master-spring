package com.masterspring.common.performance.concurrent.future;

/**
 * Created by lihuiyan on 2016/2/16.
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData futureData = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }.start();
        return futureData;
    }
}
