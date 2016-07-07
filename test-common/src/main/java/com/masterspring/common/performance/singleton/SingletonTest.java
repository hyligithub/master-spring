package com.masterspring.common.performance.singleton;

/**
 * Created by lihuiyan on 2016/1/20.
 */
public class SingletonTest {
    private SingletonTest() {
        System.out.println("SingletonTest is create");
    }

    private static SingletonTest newInstance = new SingletonTest();

    public static SingletonTest getNewInstance() {
        return newInstance;
    }

    public static void createString() {
        System.out.println("Singletontest create String");
    }
    public static void main(String[] args){
        SingletonTest.createString();
    }
}
