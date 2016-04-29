package com.masterspring.common.demo.test;

/**
 * Created by lihuiyan on 2016/3/1.
 */
public class Car {
    private String type;
    private String color;
    private Integer price;

    public void printCarInfo() {
        System.out.println("type:" + type + ",color:" + color + ",price:" + price);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
