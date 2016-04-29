package com.masterspring.common.demo.io.serializable;

import java.io.*;

/**
 * Created by lihuiyan on 2015/5/22.
 */
public class SerialTest2 {
    private static final String TMP_FILE = "serializable.txt";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    private static void testWrite() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
            ObjectB objectB = new ObjectB(1, "one", "male");
            oo.writeObject(objectB);
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testRead() {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(TMP_FILE));
            ObjectB objectB = (ObjectB) oi.readObject();
            System.out.println(objectB);
            oi.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ObjectB implements Serializable {
    private int id;
    private String name;
    private String sex;

    public ObjectB(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public String toString() {
        return "ObjectB[" + id + "--" + name + "--" + sex + "]";
    }
}
