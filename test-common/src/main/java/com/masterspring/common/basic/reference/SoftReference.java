package com.masterspring.common.basic.reference;

import java.lang.ref.Reference;

/**
 * Created by lihuiyan on 2016/6/29.
 */
public class SoftReference {
    public static void main(String[] args) {
        MyDate myDate = new MyDate();
        java.lang.ref.SoftReference sf = new java.lang.ref.SoftReference(myDate);
        ReferenceTest.drainMemory();
    }
}
