package com.masterspring.demo.aop.advice;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/3/22.
 */
public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        PrintUtil.print("greet to" + name);
    }

    @Override
    public void serviceTo(String name) {
        PrintUtil.print("service to" + name);
    }
}
