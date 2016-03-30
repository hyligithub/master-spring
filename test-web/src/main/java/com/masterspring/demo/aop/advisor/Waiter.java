package com.masterspring.demo.aop.advisor;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/3/24.
 */
public class Waiter {
    public void greetTo(String name) {
        PrintUtil.print(name);
    }

    public void serverTo(String name) {
        PrintUtil.print(name);
    }
}
