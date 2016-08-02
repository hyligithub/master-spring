package com.masterspring.common.oom.gcsuanfa;

/**
 * Created by lihuiyan on 2016/7/28.
 * 引用计数法无法解决循环引用的对象回收问题，JVM虚拟机并没有使用引用计数法来GC
 */
public class ReferenceCountGc {
    private Object instance = null;

    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        ReferenceCountGc objA = new ReferenceCountGc();
        ReferenceCountGc objB = new ReferenceCountGc();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        System.gc();
    }
}
