package com.masterspring.common.demo.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2016/3/1.
 */
public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("test.Car");
        Constructor con = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) con.newInstance();
        Method setType = clazz.getMethod("setType",String.class);
        setType.invoke(car,"suv");
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"black");
        Method setPrice = clazz.getMethod("setPrice",Integer.class);
        setPrice.invoke(car,10000);
        car.printCarInfo();
    }
}
