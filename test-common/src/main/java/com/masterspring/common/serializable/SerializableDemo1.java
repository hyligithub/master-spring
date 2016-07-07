package com.masterspring.common.serializable;

import com.masterspring.common.PrintUtil;

import java.io.*;

/**
 * Created by lihuiyan on 2016/6/22.
 */
public class SerializableDemo1 {
    public static void main(String[] args) {
        User user = new User();
        user.setName("lihy");
        user.setAge(33);
        PrintUtil.print(user);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tmpfile"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        File file = new File("tmpfile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            try {
                User user1 = (User) ois.readObject();
                PrintUtil.print(user1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
