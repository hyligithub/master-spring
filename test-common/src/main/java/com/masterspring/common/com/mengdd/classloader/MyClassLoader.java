package com.masterspring.common.com.mengdd.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    private String name; // 类加载器的名字
    private String path = "d:\\"; // 加载类的路径
    private final String fileType = ".class"; // class文件的扩展名

    public MyClassLoader(String name) {
        super(); // 让系统类加载器成为该类加载器的父加载器
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name) {
        super(parent); // 显式指定该类加载器的父加载器
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        // 重写的时候把protected改为public

        // 获取字节数组
        byte[] data = this.loadClassData(name);
        // 将字节数组转换成Class对象返回
        return this.defineClass(name, data, 0, data.length);

    }

    /**
     * 得到class文件的二进制字节数组
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {

            // 将完整类名中的.转化成\
            name = name.replace(".", "\\");
            is = new FileInputStream(new File(path + name + fileType));

            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {

                baos.write(ch);
            }

            data = baos.toByteArray();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
                baos.close();
            }
            catch (Exception e2) {
            }
        }
        return data;
    }

    // main方法用来测试
    public static void main(String[] args) throws Exception {

        MyClassLoader loader1 = new MyClassLoader("loader1");
        // loader1的父加载器是系统类加载器
        // 系统类加载器会在classpath指定的目录中加载类
        loader1.setPath("d:\\lib\\serverlib\\");

        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        // 将loader1作为loader2的父加载器
        loader2.setPath("d:\\lib\\clientlib\\");

        MyClassLoader loader3 = new MyClassLoader(null, "loader3");
        // loader3的父加载器是根类加载器
        loader3.setPath("d:\\lib\\otherlib\\");

        // 测试加载
        test(loader1);
//        test(loader3);
        System.out.println("test2---------------");
        // 测试不同命名空间的类的互相访问
//        test2(loader3);
    }

    public static void  test(ClassLoader loader) throws Exception {
        Class clazz = loader.loadClass("com.mengdd.classloader.Sample");

        Object object = clazz.newInstance();

    }

    public static void test2(ClassLoader loader) throws Exception {
        Class clazz = loader.loadClass("com.mengdd.classloader.Sample");

            Sample object = (Sample) clazz.newInstance();

        System.out.println("sample v1: " + object.v1);

    }
}