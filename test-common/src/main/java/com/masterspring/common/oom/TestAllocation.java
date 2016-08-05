package com.masterspring.common.oom;

/**
 * Created by lihuiyan on 2016/8/1.
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class TestAllocation {
    private static final int _1MB = 1024*1024;
    public static void main(String[] args) throws InterruptedException {
        byte[] a1,a2,a3,a4;
        a1 = new byte[2*_1MB];
        a2 = new byte[2*_1MB];
        a3 = new byte[2*_1MB];
        a4 = new byte[4*_1MB];
//        Thread.sleep(500);
//        System.gc();
    }
}
