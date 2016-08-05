package com.masterspring.common.oom.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/8/4.
 */
public class OOMObject {
    public static final byte[] _64K = new byte[64 * 1024];

    public static void fillHeap(int num) throws InterruptedException {
        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            Thread.sleep(500);
            list.add(_64K);
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
