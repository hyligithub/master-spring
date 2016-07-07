package com.masterspring.common.performance.singleton;

/**
 * Created by lihuiyan on 2016/1/20.
 */
public class LazySingletonTest1 {
    private LazySingletonTest1() {
        System.out.println("LazySingletonTest1 is created");
    }

    private static LazySingletonTest1 newInstance = null;

    public static LazySingletonTest1 getNewInstance() {
        if (newInstance == null) {
            synchronized (LazySingletonTest1.class) {
                if (newInstance == null) {
                    return new LazySingletonTest1();
                }
            }
        }
        return newInstance;
    }
    public static  void main(String[] args){
        LazySingletonTest1.getNewInstance();
    }
}
