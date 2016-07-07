package com.masterspring.common.classloadertest.privatereflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2016/3/2.
 */
public class PrivateReflectCarTest {
    public static void main(String[] args) throws Throwable {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("classloadertest.privatereflect.PrivateReflectCar");
        Constructor cons = clazz.getConstructor((Class[]) null);
        PrivateReflectCar car = (PrivateReflectCar) cons.newInstance();
        Field color = clazz.getDeclaredField("color");
        color.setAccessible(true);
        color.set(car, "red");

        Method method = clazz.getDeclaredMethod("drive", (Class[])null);
        method.setAccessible(true);
        method.invoke(car, (Object[])null);
    }
}
