package com.masterspring.common.classloadertest;

/**
 * Created by lihuiyan on 2016/3/1.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("current classLoader:" + classLoader);
        System.out.println("parent classLoader:" + classLoader.getParent());
        System.out.println("grandparent classLoader:" + classLoader.getParent().getParent());


    }
}
