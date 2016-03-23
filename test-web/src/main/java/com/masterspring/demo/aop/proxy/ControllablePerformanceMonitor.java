package com.masterspring.demo.aop.proxy;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by lihuiyan on 2016/3/23.
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor
        implements Monitorable {

    private ThreadLocal<Boolean> MonitorStatus = new ThreadLocal<Boolean>();


    @Override
    public void setMonitorAdvice(boolean active) {
        MonitorStatus.set(active);
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object obj = null;
        if (MonitorStatus.get() != null && MonitorStatus.get()) {
            PerformaceMonitor.begin(methodInvocation.getClass().getName() + "." + methodInvocation.getMethod().getName());
            obj = super.invoke(methodInvocation);
            PerformaceMonitor.end();
        } else {
            obj = super.invoke(methodInvocation);
        }
        return obj;
    }
}
