package com.masterspring.demo.aop.proxy;

/**
 * Created by lihuiyan on 2016/3/16.
 */
public class PerformaceMonitor {
    private static ThreadLocal<MethodPerformance> threadLocal = new ThreadLocal<MethodPerformance>();

    public static void begin(String method) {
        System.out.println("BEGIN MONITOR");
        MethodPerformance methodPerformance = new MethodPerformance(method);
        threadLocal.set(methodPerformance);
    }

    public static void end() {
        System.out.println("END MONITOR");
        MethodPerformance m = threadLocal.get();
        m.printMethodPerformance();
    }
}
