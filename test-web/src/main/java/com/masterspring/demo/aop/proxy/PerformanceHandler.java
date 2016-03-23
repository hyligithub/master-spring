package com.masterspring.demo.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class PerformanceHandler implements InvocationHandler {
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String serviceMethod = target.getClass().getName() + "." + method.getName();
        PerformaceMonitor.begin(serviceMethod);
        Object o = method.invoke(target, args);
        PerformaceMonitor.end();
        return o;
    }
}
