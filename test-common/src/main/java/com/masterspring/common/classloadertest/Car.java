package com.masterspring.common.classloadertest;

import java.io.Serializable;

/**
 * Created by lihuiyan on 2016/3/1.
 */
public class Car implements Serializable {
    private String name;
    private String color;
    private Integer price;

    public Car() {
        System.out.println("Car的类加载器的名字是：" + this.getClass().getClassLoader());
    }

    @Override
    public String toString() {
        return "name:" + name + ",color:" + color + ",price:" + price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
