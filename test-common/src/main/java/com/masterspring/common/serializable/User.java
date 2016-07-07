package com.masterspring.common.serializable;

import java.io.Serializable;

/**
 * Created by lihuiyan on 2016/6/22.
 */
public class User implements Serializable {

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name + "--" + age;
    }

    private String name;
    private int age;

}
