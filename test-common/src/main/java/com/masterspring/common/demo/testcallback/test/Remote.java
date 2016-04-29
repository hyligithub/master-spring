package com.masterspring.common.demo.testcallback.test;

/**
 * Created by lihuiyan on 2015/9/16.
 */
public class Remote {
    public void delBusiness(Object object) {
        System.out.println("call me");
        Local local = (Local) object;
        local.execute();
    }
}
