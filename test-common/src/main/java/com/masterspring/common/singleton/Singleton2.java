package com.masterspring.common.singleton;

import com.masterspring.common.concurrent.synch.Synchronized;

/**
 * Created by lihuiyan on 2016/7/10.
 * 懒汉，线程安全，效率很低
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}
