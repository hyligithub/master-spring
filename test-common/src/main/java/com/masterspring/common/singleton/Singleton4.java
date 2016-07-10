package com.masterspring.common.singleton;

/**
 * Created by lihuiyan on 2016/7/10.
 * 饿汉变种，也是有JVM保证单例的线程安全
 */
public class Singleton4 {
    private static Singleton4 singleton4 = null;

    static {
        singleton4 = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return singleton4;
    }
}
