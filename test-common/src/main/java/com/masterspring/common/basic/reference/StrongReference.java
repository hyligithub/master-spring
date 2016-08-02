package com.masterspring.common.basic.reference;

/**
 * Created by lihuiyan on 2016/6/29.
 */
public class StrongReference {
    public static void main(String[] args) throws InterruptedException {
        MyDate myDate = new MyDate();
        myDate = null;
        System.gc();
        Thread.sleep(500);
    }
}
