package com.masterspring.common.basic.reference;

/**
 * Created by lihuiyan on 2016/6/29.
 */
public class StrongReference {
    public static void main(String[] args) {
        MyDate myDate = new MyDate();
        System.gc();
    }
}
