package com.masterspring.common.classloadertest;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lihuiyan on 2016/3/2.
 */
public class ClassLoderDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader clazzLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String className = name.substring(name.lastIndexOf(".") + 1) + ".calss";
                    InputStream is = getClass().getResourceAsStream(className);
                    if (is == null)
                        return super.loadClass(name);
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return this.defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        String currentClass = "classloadertest.ClassLoderDemo";
        Class clazz = clazzLoader.loadClass(currentClass);
        Object object = clazz.newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.masterspring.common.classloadertest.ClassLoderDemo);
        System.out.println(object.getClass().getClassLoader());
    }
}
