package com.masterspring.common.demo.java7.concurrency.threadlocal;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.SleepUtils;

/**
 * Created by lihuiyan on 2016/5/4.
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void start() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long cost() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) {
        start();
        SleepUtils.second(5);
        PrintUtil.print("cost time:" + cost());
    }
}
