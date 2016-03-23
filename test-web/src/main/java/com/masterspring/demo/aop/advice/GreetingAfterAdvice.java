package com.masterspring.demo.aop.advice;

import com.masterspring.common.PrintUtil;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2016/3/23.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        PrintUtil.print("greeting after advice");
    }
}
