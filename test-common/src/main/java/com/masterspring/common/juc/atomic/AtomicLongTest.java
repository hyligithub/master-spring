package com.masterspring.common.juc.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lihuiyan on 2015/5/4.
 */
public class AtomicLongTest {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.set(0x0123456789ABCDEFL);
//        System.out.printf("%20s : 0x%016X\n", "get()=", atomicLong.get());
//        System.out.printf("%20s : 0x%016X\n", "intValue()", atomicLong.intValue());
//        System.out.printf("%20s : 0x%016X\n", "longValue()", atomicLong.longValue());
//        System.out.printf("%20s : %s\n", "doubleValue()", atomicLong.doubleValue());
//        System.out.printf("%20s : %s\n", "floatValue()", atomicLong.floatValue());
//
//        System.out.printf("%20s : 0x%016X\n", "getAndDecrement()", atomicLong.getAndDecrement());
//        System.out.printf("%20s : 0x%016X\n", "decrementAndGet()", atomicLong.decrementAndGet());
//        System.out.printf("%20s : 0x%016X\n", "getAndIncrement()", atomicLong.getAndIncrement());
//        System.out.printf("%20s : 0x%016X\n", "incrementAndGet()", atomicLong.incrementAndGet());
//
//        System.out.printf("%20s : 0x%016X\n", "addAndGet(0x10)", mAtoLong.addAndGet(0x10));
//        System.out.printf("%20s : 0x%016X\n", "getAndAdd(0x10)", mAtoLong.getAndAdd(0x10));
//
//        System.out.printf("\n%20s : 0x%016X\n", "get()", mAtoLong.get());
//
//        System.out.printf("%20s : %s\n", "compareAndSet()", mAtoLong.compareAndSet(0x12345679L, 0xFEDCBA9876543210L));
//        System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
    }
}
