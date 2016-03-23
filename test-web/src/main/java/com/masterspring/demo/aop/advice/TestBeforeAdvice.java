package com.masterspring.demo.aop.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lihuiyan on 2016/3/22.
 */
public class TestBeforeAdvice {
    public static void main(String[] args) {
        Waiter waiter = new NaiveWaiter();
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
        ProxyFactory pf = new ProxyFactory();
//        pf.setInterfaces(waiter.getClass().getInterfaces());//指定对接口代理，JDK动态代理
//        pf.setOptimize(true);//启用优化，如果指定对接口进行代理，此处还会使用cglib进行代理
        pf.setTarget(waiter);
        pf.addAdvice(beforeAdvice);
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("join");
        proxy.serviceTo("Tom");
        testAdvice();
    }

    private static void testAdvice() {
        String classPath = "spring/spring-config.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPath);
        Waiter waiter = (Waiter) applicationContext.getBean("waiter");
        waiter.serviceTo("aa");
        waiter.greetTo("bb");
    }
}
