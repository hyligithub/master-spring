package com.masterspring.common.performance.concurrent.future.jdkfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2016/2/16.
 */
public class RealData implements Callable<String> {
    private String queryStr;

    public RealData(String queryStr) {
        this.queryStr = queryStr;
    }

    @Override
    public String call() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("这里开始构造数据，应该很慢，queryStr=" + queryStr);
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(i).append(",");
            Thread.sleep(1000);
        }
        return stringBuffer.toString();
    }
}
