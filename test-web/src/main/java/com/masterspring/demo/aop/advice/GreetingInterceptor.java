package com.masterspring.demo.aop.advice;

import com.masterspring.common.PrintUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by lihuiyan on 2016/3/23.
 */
public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];
        PrintUtil.print("How are you:" + clientName);
        methodInvocation.proceed();
        PrintUtil.print("enjoy yourself");
        return null;
    }
}
