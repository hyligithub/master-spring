package com.masterspring.common.demo.testcallback.callbacktest;

/**
 * Created by lihuiyan on 2015/4/23.
 */
public class Remote {
    public void callMe(String message, Object object) {
        System.out.println("you call me :" + message);
        Local local = (Local) object;
        local.execute("callback");
    }
}
