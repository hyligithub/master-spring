package com.masterspring.common.com.classloder;

/**
 * Created by lihuiyan on 2016/3/2.
 */
public class ClassLoderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoder loder1 = new MyClassLoder("loder1");
        Class<?> clazz = loder1.loadClass("com.classloder.Student");
        Object o = clazz.newInstance();
        System.out.println(o.getClass().getClassLoader());
    }
}
