package com.masterspring.common.basic.reference;

import java.lang.ref.WeakReference;

/**
 * Created by lihuiyan on 2016/6/29.
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        MyDate myDate = new MyDate();
        WeakReference sf = new WeakReference(myDate);
        System.gc();
    }
}
