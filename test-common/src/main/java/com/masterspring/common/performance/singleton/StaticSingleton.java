package com.masterspring.common.performance.singleton;

/**
 * Created by lihuiyan on 2016/1/20.
 */
public class StaticSingleton {
    private StaticSingleton() {
        System.out.println("staticsingleton is created");
    }

    private static class StaticSingletonHolder {
        private static StaticSingleton staticSingleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return StaticSingletonHolder.staticSingleton;
    }

    public static void main(String[] args){
        StaticSingleton.getInstance();
    }
}
