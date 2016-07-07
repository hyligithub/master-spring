package com.masterspring.common.classloadertest;

/**
 * Created by lihuiyan on 2016/3/2.
 */
public class TestMyClassloader {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyClassloader loder1 = new MyClassloader("loder1");
        loder1.setPath("D:\\lib\\loder1\\");
        test(loder1);

    }

    private static void test(ClassLoader loder) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = loder.loadClass("classlodertest.Car");
        Object o = clazz.newInstance();
    }
}
