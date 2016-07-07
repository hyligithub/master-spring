package com.masterspring.common.com.classloder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by lihuiyan on 2016/3/2.
 */
public class MyClassLoder extends ClassLoader {

    private String name;
    private String path;
    private String type = ".class";

    public MyClassLoder(String name) {
        this.setName(name);
    }

    public MyClassLoder(ClassLoader parent, String name) {
        this.setName(name);
    }

    @Override
    public Class<?> findClass(String name) {
        path = MyClassLoder.getSystemClassLoader().getResource("").getPath();
        System.out.println(path);
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    public byte[] loadClassData(String name) {
        try {
            name = name.replace(".", "//");
            FileInputStream fileInputStream = new FileInputStream(new File(path + name + type));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fileInputStream.read()) != -1) {
                byteArrayOutputStream.write(b);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
