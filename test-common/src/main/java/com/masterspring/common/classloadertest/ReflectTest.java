package com.masterspring.common.classloadertest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2016/3/1.
 */
public class ReflectTest {
    public static void main(String[] args) throws Throwable {
        testReflect();
    }

    private static void testReflect() throws Throwable {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("classloadertest.Car");
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) cons.newInstance();
        Method setName = clazz.getDeclaredMethod("setName", String.class);
        setName.invoke(car, "bmw");
        Method setColor = clazz.getDeclaredMethod("setColor", String.class);
        setColor.invoke(car, "black");
        Method setPrice = clazz.getDeclaredMethod("setPrice", Integer.class);
        setPrice.invoke(car, 10000);
        System.out.println(car);
    }
}
