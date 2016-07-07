package com.masterspring.common.performance.singleton;

/**
 * Created by lihuiyan on 2016/1/20.
 */
public class LazySingletonTest {
    private LazySingletonTest() {
        System.out.println("lazy sintleton is created");
    }

    private static LazySingletonTest newInstance = null;

    public static synchronized LazySingletonTest getNewInstance() {
        if (newInstance == null) {
            return new LazySingletonTest();
        }
        return newInstance;
    }
    public static void main(String[] args){
        LazySingletonTest.getNewInstance();
    }
}
