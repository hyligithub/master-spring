package com.masterspring.common.singleton;

/**
 * Created by lihuiyan on 2016/7/10.
 * 懒汉模式，线程不安全
 */
public class Singleton1 {
    private static Singleton1 singleton1;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
