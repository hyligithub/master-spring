package com.masterspring.common.singleton;

/**
 * Created by lihuiyan on 2016/7/10.
 * 静态内部类实现单例，懒加载模式，推荐
 */
public class Singleton5 {

    private static class SingleHolder {
        private static final Singleton5 singleton5 = new Singleton5();
    }

    private Singleton5() {
    }

    public static final Singleton5 getInstance() {
        return SingleHolder.singleton5;
    }
}
