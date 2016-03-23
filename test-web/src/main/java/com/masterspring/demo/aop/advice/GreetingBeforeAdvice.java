package com.masterspring.demo.aop.advice;

import com.masterspring.common.PrintUtil;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2016/3/22.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String) objects[0];
        PrintUtil.print("How are you:" + clientName);
    }
}
