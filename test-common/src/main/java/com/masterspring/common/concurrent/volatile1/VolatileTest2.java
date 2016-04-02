package com.masterspring.common.concurrent.volatile1;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihuiyan on 2016/4/1.
 */
public class VolatileTest2 {

    private volatile VolatileObj volatileObj;

    private static int NUM = 10;

    public void initVolatileObj() {
        volatileObj = new VolatileObj();
    }

    @Test
    public void doIt() {
        initVolatileObj();
        while (NUM > 0) {
            if (volatileObj.getName() != null) {
                PrintUtil.print("VolatileObj 初始化成功");
            }
            NUM--;
        }
    }

    @Test
    public void newExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    initVolatileObj();
                    while (NUM > 0) {
                        if (volatileObj.getName() != null) {
                            PrintUtil.print("VolatileObj 初始化成功" + Thread.currentThread().getName());
                        }
                        NUM--;
                    }
                }
            });
        }
    }
}
