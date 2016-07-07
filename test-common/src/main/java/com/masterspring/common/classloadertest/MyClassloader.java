package com.masterspring.common.classloadertest;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lihuiyan on 2016/3/2.
 */
public class MyClassloader extends ClassLoader {
    private String name;//类加载的名字
    private String path;//类加载路径
    private final String type = ".class";//类扩展名

    public MyClassloader(String name) {
        super();
        this.name = name;
    }

    public MyClassloader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    private byte[] loadClassData(String name) {
        name = name.replace(".", "\\");
        File file = new File(getPath() + name + type);
        byte[] bytes = new byte[(int) file.length()];
        try {
            InputStream is = new FileInputStream(file);
            int len = is.read(bytes);
            is.close();
        } catch (IOException ex) {

        }
        return bytes;
    }

    @Override
    public Class<?> findClass(String name) {
        byte[] bytes = this.loadClassData(name);
        return this.defineClass(name, bytes, 0, bytes.length);
    }

    @Override
    public String toString() {
        return "MyClassLoader:" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
