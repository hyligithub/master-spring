package com.masterspring.demo.aop.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lihuiyan on 2016/3/23.
 */
public class TestIntroduce {

    public static void main(String[] args) {
        String classPath = "spring/spring-config.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPath);
        ForumServiceImpl forumService = (ForumServiceImpl) applicationContext.getBean("forumService");
        forumService.removeForum(9);
        forumService.removeTopic(8);
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorAdvice(true);
        forumService.removeForum(99);
        forumService.removeTopic(88);

    }
}
