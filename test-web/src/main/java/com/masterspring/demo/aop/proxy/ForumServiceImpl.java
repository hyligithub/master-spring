package com.masterspring.demo.aop.proxy;

/**
 * Created by lihuiyan on 2016/3/16.
 */
public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
//        PerformaceMonitor.begin("removeTopic");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        PerformaceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
//        PerformaceMonitor.begin("removeForum");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        PerformaceMonitor.end();
    }
}
