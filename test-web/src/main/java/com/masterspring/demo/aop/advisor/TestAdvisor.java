package com.masterspring.demo.aop.advisor;

import com.masterspring.demo.aop.advice.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lihuiyan on 2016/3/24.
 */
public class TestAdvisor {

    public static void main(String[] args) {
        String classPath = "spring/spring-config-service.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPath);
//        Waiter waiter = (Waiter) applicationContext.getBean("waiterProxy");
//        Seller seller = (Seller) applicationContext.getBean("sellerProxy");
        Waiter waiter = (Waiter) applicationContext.getBean("regexWaiter");

        waiter.greetTo("aa");
        waiter.serverTo("bb");

//        seller.greetTo("cc");
    }
}
