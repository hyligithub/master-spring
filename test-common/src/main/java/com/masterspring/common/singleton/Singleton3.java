package com.masterspring.common.singleton;

/**
 * Created by lihuiyan on 2016/7/10.
 * 饿汉，由JVM保证单例初始化的线程安全
 */
public class Singleton3 {
    private static Singleton3 singleton3 = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return singleton3;
    }
}
