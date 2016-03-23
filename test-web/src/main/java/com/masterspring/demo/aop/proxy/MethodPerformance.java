package com.masterspring.demo.aop.proxy;

/**
 * Created by lihuiyan on 2016/3/16.
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String method;

    public MethodPerformance(String method) {
        this.method = method;
        begin = System.currentTimeMillis();
    }

    public void printMethodPerformance() {
        end = System.currentTimeMillis();
        long xx = end - begin;
        System.out.println(method + " 花费 " + xx + " 毫秒");
    }
}
