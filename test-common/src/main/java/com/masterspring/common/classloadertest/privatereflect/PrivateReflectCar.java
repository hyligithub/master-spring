package com.masterspring.common.classloadertest.privatereflect;

/**
 * Created by lihuiyan on 2016/3/2.
 */
public class PrivateReflectCar {

    private String color;

    protected void drive() {
        System.out.println("drive private car.the color is " + color);
    }
}
