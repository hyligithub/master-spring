package com.masterspring.demo.aop.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by lihuiyan on 2016/3/16.
 */
public class TestProxy {
    public static void main(String[] args){
//        ForumService target = new ForumServiceImpl();
////        forumService.removeForum(1);
////        forumService.removeTopic(2);
//
//        PerformanceHandler performanceHandler = new PerformanceHandler(target);
//        ForumService proxy =(ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),performanceHandler);
//        proxy.removeForum(1);
//        proxy.removeTopic(11);

        CgligProxy cgligProxy = new CgligProxy();
        ForumService forumService = (ForumService)cgligProxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(11);
        forumService.removeTopic(22);
    }
}
