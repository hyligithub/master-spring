package com.masterspring.common.oom;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by lihuiyan on 2015/5/21.
 * -Xms20M -MaxDirectMemorySize=10M
 * 直接内存溢出
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
